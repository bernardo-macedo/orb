/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_CustomerFacadeLocal;
import com.orb.entities.ORB_Customer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author RenataCristina
 */
@Named(value = "customerController")
@RequestScoped
public class CustomerController implements Serializable {

    @EJB
    private ORB_CustomerFacadeLocal customerFacade;
    
    @ManagedProperty(value = "#{propertyController}")
    private PropertyController propertyController;
    
    @ManagedProperty(value = "#{userController}")
    private UserController userController;
    
    private ORB_Customer customer;
    private String customerUsername;
    private double maxRent;

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
    }

    public PropertyController getPropertyController() {
        return propertyController;
    }

    public void setPropertyController(PropertyController propertyController) {
        this.propertyController = propertyController;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public ORB_Customer getCustomer() {
        return customer;
    }

    public void setCustomer(ORB_Customer customer) {
        this.customer = customer;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public double getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(double maxRent) {
        this.maxRent = maxRent;
    }
    
    public void retrieveCustomer() {
        userController = new UserController();
        userController.setUsername(customerUsername);
        userController.retrieveUser();
        customer = customerFacade.find(userController.getUser().getId());
    }
}
