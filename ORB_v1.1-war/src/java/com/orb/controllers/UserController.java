/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.UserFacadeLocal;
import com.orb.entities.ORB_User;
import com.orb.util.PasswordHash;
import java.io.Serializable;
import java.util.Calendar;
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
    private ORB_User user;
    
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
            ORB_User user = new ORB_User();
            user.setGivenName(givenName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setTypeOfAccount(typeOfAccount);
            user.setCreationTimeStamp(Calendar.getInstance());
            userFacade.create(user);
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
            System.out.println("Auth successful");
            if (user.getTypeOfAccount().equalsIgnoreCase(AGENT_ACCOUNT)) 
                System.out.println("Agent logged in");
            else if (user.getTypeOfAccount().equalsIgnoreCase(OWNER_ACCOUNT))
                System.out.println("Owner logged in");
            else
                System.out.println("Customer logged in");
        } else {
            System.out.println("Username and Password do not match");
        }
    }
    
    public void logout() {
        user = null;
        System.out.println("Logged out");
    }
    
}
