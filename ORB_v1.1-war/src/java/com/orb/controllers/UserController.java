/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_CustomerFacadeLocal;
import com.orb.ejb.ORB_OwnerFacadeLocal;
import com.orb.ejb.ORB_UserSessionFacadeLocal;
import com.orb.ejb.UserFacadeLocal;
import com.orb.entities.ORB_Customer;
import com.orb.entities.ORB_Owner;
import com.orb.entities.ORB_User;
import com.orb.entities.ORB_UserSession;
import com.orb.util.PasswordHash;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author -Bernardo
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final String AGENT_ACCOUNT = "agent";
    private static final String OWNER_ACCOUNT = "owner";
    private static final String CUSTOMER_ACCOUNT = "customer";
    
    @EJB
    private UserFacadeLocal userFacade;
    
    @EJB
    private ORB_OwnerFacadeLocal ownerFacade;
    
    @EJB
    private ORB_CustomerFacadeLocal customerFacade;
    
    @EJB
    private ORB_UserSessionFacadeLocal sessionFacade;
    
    private ORB_User user;
    private ORB_UserSession userSession;
    
    // Authentication variables
    private String username;
    private String password;
    // Update account
    private String newPassword;
    // Other user info
    private String givenName;
    private String lastName;
    private String email;
    private String typeOfAccount;
    
    private boolean isCustomer;

    public boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public ORB_UserSessionFacadeLocal getSessionFacade() {
        return sessionFacade;
    }

    public void setSessionFacade(ORB_UserSessionFacadeLocal sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    public ORB_UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(ORB_UserSession userSession) {
        this.userSession = userSession;
    }
    
    public UserFacadeLocal getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacadeLocal userFacade) {
        this.userFacade = userFacade;
    }

    public ORB_OwnerFacadeLocal getOwnerFacade() {
        return ownerFacade;
    }

    public void setOwnerFacade(ORB_OwnerFacadeLocal ownerFacade) {
        this.ownerFacade = ownerFacade;
    }

    public ORB_CustomerFacadeLocal getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(ORB_CustomerFacadeLocal customerFacade) {
        this.customerFacade = customerFacade;
    }
    
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        }
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        if (typeOfAccount.equalsIgnoreCase(AGENT_ACCOUNT) || typeOfAccount.equalsIgnoreCase(CUSTOMER_ACCOUNT) || 
                typeOfAccount.equalsIgnoreCase(OWNER_ACCOUNT)) {
            this.typeOfAccount = typeOfAccount;
        }
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Creates a new instance of UserController
     */
    public UserController() {}

    public ORB_User getUser() {
        return user;
    }

    public void setUser(ORB_User user) {
        this.user = user;
    }
    
    public void addUser() {
        if (userFacade.findByUsername(username) == null) {
            if (typeOfAccount.equalsIgnoreCase(AGENT_ACCOUNT)) {
                
            } else if (typeOfAccount.equalsIgnoreCase(OWNER_ACCOUNT)) {
                ORB_Owner owner = new ORB_Owner();
                owner.setUsername(username);
                owner.setGivenName(givenName);
                owner.setLastName(lastName);
                owner.setEmail(email);
                owner.setPassword(password);
                owner.setTypeOfAccount(typeOfAccount);
                owner.setCreationTimeStamp(Calendar.getInstance());
                ownerFacade.create(owner);
                // Set this user in the session
                user = owner;
            } else if (typeOfAccount.equalsIgnoreCase(CUSTOMER_ACCOUNT)) {
                ORB_Customer customer = new ORB_Customer();
                customer.setUsername(username);
                customer.setGivenName(givenName);
                customer.setLastName(lastName);
                customer.setEmail(email);
                customer.setPassword(password);
                customer.setTypeOfAccount(typeOfAccount);
                customer.setCreationTimeStamp(Calendar.getInstance());
                customer.setMaxRent(600);
                customer.setRenting(false);
                customer.setVisitingList(null);
                customerFacade.create(customer);
                // Set this user in the session
                user = customer;
            }
            /*
            ORB_User user = new ORB_User();
            user.setGivenName(givenName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setTypeOfAccount(typeOfAccount);
            user.setCreationTimeStamp(Calendar.getInstance());
            userFacade.create(user);
            */
            System.out.println("created");
        } else {
            System.out.println("This user is already registered");
        }
    }
    
    public void retrieveUser() {
        if (username != null)
            user = userFacade.findByUsername(username);
        else if (email != null)
            user = userFacade.findByEmail(email);
        if (user != null) {
            System.out.println("User retrieved");
        } else {
            System.out.println("User not retrieved");
        }
    }
    
    public void updateUser() {
        if (!user.getEmail().equals(email)) {
            // If the email changed, verify if the new one is unique
            if (userFacade.findByEmail(email) == null) {
                // No user with this new email. Good to go.
                user.setEmail(email);
            } else {
                System.out.println("Email already taken");
                return;
            }
        }
        if (newPassword != null) {
            // If the password changed, verify if the old one is valid
            if (PasswordHash.validatePassword(password, user.getPassword())) {
                user.setPassword(password); // The persistence deals with the hashing
            } else {
                System.out.println("Wrong password");
                return;
            }
        }
    }
    
    public void removeUser() {
        if (user != null) {
            user.setDeleted(true);
            userFacade.edit(user);
            logout();
        }
    }
    
    public void login() {
        ORB_User possibleUser = userFacade.findByUsername(username);
        if (possibleUser != null && !possibleUser.isDeleted() && PasswordHash.validatePassword(password, possibleUser.getPassword())) {
            user = possibleUser;
            userSession = new ORB_UserSession(UUID.randomUUID().toString());
            userSession.setUser(user);
            sessionFacade.create(userSession);
            System.out.println("Auth successful");
            if (user.getTypeOfAccount().equalsIgnoreCase(AGENT_ACCOUNT)) 
                System.out.println("Agent logged in");
            else if (user.getTypeOfAccount().equalsIgnoreCase(OWNER_ACCOUNT))
                System.out.println("Owner logged in");
            else
                System.out.println(user.getTypeOfAccount() + " logged in");
        } else {
            System.out.println("Username and Password do not match");
        }
    }
    
    public void logout() {
        user = null;
        sessionFacade.remove(sessionFacade.getCurrentSession());
        System.out.println("Logged out");
    }
    
}
