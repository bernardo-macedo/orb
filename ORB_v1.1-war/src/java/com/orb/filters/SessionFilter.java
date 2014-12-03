/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.filters;

import com.orb.ejb.ORB_UserSessionFacadeLocal;
import com.orb.entities.ORB_UserSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author -Bernardo
 */
@ManagedBean
@SessionScoped
public class SessionFilter implements Filter, Serializable {
    private static final String MANAGED_BEAN_NAME = "userSession";
    private static final String COOKIE_NAME = "SessionFilter.cookieId";
    private static final int COOKIE_MAX_AGE = 31536000; // 60*60*24*365 seconds; 1 year.
    
    @EJB
    private ORB_UserSessionFacadeLocal sessionFacade;
    
    private ORB_UserSession userSession;

    public ORB_UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(ORB_UserSession userSession) {
        this.userSession = userSession;
    }
    
    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpRequest.getSession();
        userSession = (ORB_UserSession) httpSession.getAttribute(MANAGED_BEAN_NAME);
        
        if (userSession == null) {

            // No UserSession found in HttpSession; lookup ID in cookie.
            String cookieId = getCookieValue(httpRequest, COOKIE_NAME);

            if (cookieId != null) {
                try {
                    userSession = sessionFacade.find(cookieId); 
                } catch (Exception e) {
                    setErrorMessage("Loading UserSession failed.", e);
                }
            }

            if (userSession == null) {
                cookieId = UUID.randomUUID().toString();
                userSession = new ORB_UserSession(cookieId);
                try {
                    sessionFacade.create(userSession);
                } catch (Exception e) {
                    setErrorMessage("Creating UserSession failed.", e);
                }

                // Put ID in cookie.
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                setCookieValue(httpResponse, COOKIE_NAME, cookieId, COOKIE_MAX_AGE);
            }

            // Set UserSession in current HttpSession.
            httpSession.setAttribute(MANAGED_BEAN_NAME, userSession);
        }
        // Add hit and update UserSession.
        userSession.addHit();
        try {
            sessionFacade.edit(userSession);
        } catch (Exception e) {
            httpSession.setAttribute(MANAGED_BEAN_NAME, null);
            doFilter(request, response, chain);
            return;
        }

        // Continue filtering.
        chain.doFilter(request, response);
    
    }

    @Override
    public void destroy() {}
    
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
    public static void setCookieValue(
        HttpServletResponse response, String name, String value, int maxAge)
    {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    private void setErrorMessage(String message, Exception e) {
        System.out.println("Exception: " + message);
        e.printStackTrace();
    }
}
