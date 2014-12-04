/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_LocationFacadeLocal;
import com.orb.entities.ORB_Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author RenataCristina
 */
@Named(value = "locationController")
@RequestScoped
public class LocationController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ORB_LocationFacadeLocal locationFacade;

    /**
     * Creates a new instance of LocationController
     */
    public LocationController() {
    }
    
    public ORB_Location findLocationByName(String name) {
        return locationFacade.findLocationByName(name);
    }
    
    public List<ORB_Location> list() {
        return locationFacade.findAll();
    }
    
    public List<String> getAllLocationsName() {
        List<ORB_Location> locations = new ArrayList<>();
        List<String> results = new ArrayList<>();
        locations = locationFacade.findAll();
        if (locations != null) {
            for (ORB_Location location : locations) {
                results.add(location.getName());
            }
        }
        return results;
    }
    
}
