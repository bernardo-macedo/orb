/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_VisitHistoryFacadeLocal;
import com.orb.entities.ORB_VisitHistory;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author RenataCristina
 */
@Named(value = "visitHistoryController")
@RequestScoped
public class VisitHistoryController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ORB_VisitHistoryFacadeLocal visitHistoryFacade;
    private Long ownerId;
    private int startYear;
    private int endYear;
    private int startMonth;
    private int endMonth;

    /**
     * Creates a new instance of VisitHistoryController
     */
    public VisitHistoryController() {}

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }
    
    public List<ORB_VisitHistory> findHistoryByPeriod() {
        return visitHistoryFacade.findHistoryByPeriod(ownerId, startYear, startMonth, endYear, endMonth);
    }
    
}
