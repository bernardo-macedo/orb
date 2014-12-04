/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_VisitHistoryFacadeLocal;
import com.orb.entities.ORB_Owner;
import com.orb.entities.ORB_VisitHistory;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

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
    
    @ManagedProperty(value = "#{ownerController}")
    private OwnerController ownerController;
    
    private ORB_VisitHistory visit;
    private ORB_Owner owner;
    
    private int startYear;
    private int endYear;
    private int startMonth;
    private int endMonth;
    // To add visits
    private Long propertyId;
    private int visitMonth;
    private int visitYear;
    
    private boolean showResults = false;
    private boolean noResults = true;
    private int visitsTotal = 0;
    private List<ORB_VisitHistory> resultsList = null;
    
    private String startMonthParsed;
    private String endMonthParsed;

    /**
     * Creates a new instance of VisitHistoryController
     */
    public VisitHistoryController() {}

    public boolean isNoResults() {
        return noResults;
    }

    public void setNoResults(boolean noResults) {
        this.noResults = noResults;
    }

    public String getStartMonthParsed() {
        return startMonthParsed;
    }

    public void setStartMonthParsed(String startMonthParsed) {
        this.startMonthParsed = startMonthParsed;
    }

    public String getEndMonthParsed() {
        return endMonthParsed;
    }

    public void setEndMonthParsed(String endMonthParsed) {
        this.endMonthParsed = endMonthParsed;
    }

    public List<ORB_VisitHistory> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<ORB_VisitHistory> resultsList) {
        this.resultsList = resultsList;
    }

    public boolean isShowResults() {
        return showResults;
    }

    public void setShowResults(boolean showResults) {
        this.showResults = showResults;
    }

    public int getVisitsTotal() {
        return visitsTotal;
    }

    public void setVisitsTotal(int visitsTotal) {
        this.visitsTotal = visitsTotal;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
    
    public int getVisitMonth() {
        return visitMonth;
    }

    public void setVisitMonth(int visitMonth) {
        this.visitMonth = visitMonth;
    }

    public int getVisitYear() {
        return visitYear;
    }

    public void setVisitYear(int visitYear) {
        this.visitYear = visitYear;
    }
    
    public ORB_VisitHistory getVisit() {
        return visit;
    }

    public void setVisit(ORB_VisitHistory visit) {
        this.visit = visit;
    }
    
    public ORB_Owner getOwner() {
        return owner;
    }

    public void setOwner(ORB_Owner owner) {
        this.owner = owner;
    }

    public OwnerController getOwnerController() {
        return ownerController;
    }

    public void setOwnerController(OwnerController ownerController) {
        this.ownerController = ownerController;
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
    
    public void findHistoryByPeriod() {
        startMonthParsed = parseMonth(startMonth);
        endMonthParsed = parseMonth(endMonth);
        List<ORB_VisitHistory> resultList = visitHistoryFacade.findHistoryByPeriod(owner.getId(), startYear, startMonth, endYear, endMonth);
        if (resultList != null) {
            showResults = true;
            noResults = false;
            for (ORB_VisitHistory result : resultList) {
                visitsTotal = visitsTotal + result.getVisitsNumber();
            }
        }
        resultsList = resultList;
    }
    
    public void addVisit() {
        // Verify if there already are visits for this property in this period
        visit = visitHistoryFacade.findVisit(propertyId, visitMonth, visitYear);
        if (visit != null) {
            visit.setVisitsNumber(visit.getVisitsNumber() + 1);
            visitHistoryFacade.edit(visit);
        } else {
            PropertyController controller = new PropertyController();
            controller.setPropertyId(propertyId);
            visit = new ORB_VisitHistory();
            visit.setMonth(visitMonth);
            visit.setYear(visitYear);
            visit.setProperty(controller.findPropertyById());
            visit.setVisitsNumber(1);
            visitHistoryFacade.create(visit);
        }
    }
    
    public String parseMonth(int month) {
        switch(month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "February";
            case 4: return "February"; 
            case 5: return "February";
            case 6: return "February";
            case 7: return "February";
            case 8: return "February";
            case 9: return "February";
            case 10: return "February";
            case 11: return "February";
            case 12: return "February";
            default: return null; 
        }
    }
    
}
