/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_RentFacadeLocal;
import com.orb.entities.ORB_Rent;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author RenataCristina
 */
@Named(value = "rentController")
@RequestScoped
public class RentController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ORB_RentFacadeLocal rentFacade;
    private ORB_Rent rent;
    
    private String email;
    private String typeOfCC;
    private int creditCardNumber;
    private String cardholderName;
    private int expiryMonth;
    private int expiryYear;

    /**
     * Creates a new instance of RentController
     */
    public RentController() {}

    public ORB_Rent getRent() {
        return rent;
    }

    public void setRent(ORB_Rent rent) {
        this.rent = rent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCC() {
        return typeOfCC;
    }

    public void setTypeOfCC(String typeOfCC) {
        this.typeOfCC = typeOfCC;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }
    
    public boolean addRent() {
        try {
            rentFacade.create(rent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean updateRent() {
        try {
            rentFacade.edit(rent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
        
    public boolean deleteRent() {
        try {
            rentFacade.remove(rent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
