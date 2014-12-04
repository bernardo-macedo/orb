/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_LocationFacadeLocal;
import com.orb.ejb.ORB_OwnerFacadeLocal;
import com.orb.ejb.ORB_PropertyFacadeLocal;
import com.orb.ejb.ORB_TypeOfPropertyFacadeLocal;
import com.orb.ejb.ORB_UserSessionFacadeLocal;
import com.orb.entities.ORB_Location;
import com.orb.entities.ORB_Owner;
import com.orb.entities.ORB_Property;
import com.orb.entities.ORB_TypeOfProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author RenataCristina
 */
@Named(value = "propertyController")
@RequestScoped
public class PropertyController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ORB_PropertyFacadeLocal propertyFacade;
    
    @EJB
    private ORB_LocationFacadeLocal locationFacade;
    
    @EJB
    private ORB_TypeOfPropertyFacadeLocal typeFacade;
    
    @EJB
    private ORB_OwnerFacadeLocal ownerFacade;
    
    @EJB
    private ORB_UserSessionFacadeLocal sessionFacade;
    
    private ORB_Property property;
/*
    @ManagedProperty(value = "#{ownerController}")
    private OwnerController ownerController;
*/
    LocationController locationController = new LocationController();
    TypeOfPropertyController typeController = new TypeOfPropertyController();

    ORB_Location locationEntity;
    ORB_TypeOfProperty typeEntity;
    
    private Long propertyId;
    private String address;
    private int bedroomsNumber;
    private int bathroomsNumber;
    private int othersNumber;
    private double rent;
    private String location;
    private String type;
    private Long ownerId;
    private int number;
    private double minRent;
    private double maxRent;
    
    private List<ORB_Property> resultsList = null;
    private boolean showResults = false;
    private boolean noResults = true;

    private List<ORB_Location> locationList;
    private ORB_Owner owner;

            
            
    /**
     * Creates a new instance of PropertyController
     */
    public PropertyController() {}
    
    @PostConstruct
    public void init() {
        locationList = locationFacade.findAll();
        if (locationList != null) System.out.println("LocList preenchida");
    }
    
    public ORB_Owner getOwner() {
        return owner;
    }

    public void setOwner(ORB_Owner owner) {
        this.owner = owner;
    }

    public boolean isShowResults() {
        return showResults;
    }

    public void setShowResults(boolean showResults) {
        this.showResults = showResults;
    }
    
    public List<ORB_Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<ORB_Location> locationList) {
        this.locationList = locationList;
    }
    
    public ORB_PropertyFacadeLocal getPropertyFacade() {
        return propertyFacade;
    }

    public boolean isNoResults() {
        return noResults;
    }

    public void setNoResults(boolean noResults) {
        this.noResults = noResults;
    }

    public List<ORB_Property> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<ORB_Property> resultsList) {
        this.resultsList = resultsList;
    }
    
    public ORB_Property getProperty() {
        return property;
    }

    public void setProperty(ORB_Property property) {
        this.property = property;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedroomsNumber() {
        return bedroomsNumber;
    }

    public void setBedroomsNumber(int bedroomsNumber) {
        this.bedroomsNumber = bedroomsNumber;
    }

    public int getBathroomsNumber() {
        return bathroomsNumber;
    }

    public void setBathroomsNumber(int bathroomsNumber) {
        this.bathroomsNumber = bathroomsNumber;
    }

    public int getOthersNumber() {
        return othersNumber;
    }

    public void setOthersNumber(int othersNumber) {
        this.othersNumber = othersNumber;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getMinRent() {
        return minRent;
    }

    public void setMinRent(double minRent) {
        this.minRent = minRent;
    }

    public double getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(double maxRent) {
        this.maxRent = maxRent;
    }

    
    public boolean addProperty() {
        try {
            owner = ownerFacade.find(sessionFacade.getCurrentSession().getUser().getId());
            if (owner == null) {
                System.out.println("Owner = null");
            }
            property = new ORB_Property();
            //locationEntity = new ORB_Location();
            //typeEntity = new ORB_TypeOfProperty();
            property.setAddress(address);
            property.setBedroomsNumber(bedroomsNumber);
            property.setBathroomsNumber(bathroomsNumber);
            property.setOthersNumber(othersNumber);
            property.setRent(rent);
            property.setDeleted(false);
            property.setRented(false);
            //locationEntity.setId(Long.parseLong("1"));
            //locationEntity.setName(location);
            locationEntity = locationFacade.findLocationByName(location);
            property.setLocation(locationEntity);
            //typeEntity.setId(Long.parseLong("2"));
            //typeEntity.setTypeDescription(type);
            typeEntity = typeFacade.findTypeByName(type);
            property.setTypeOfProperty(typeEntity);
            property.setOwner(owner);
            propertyFacade.create(property);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1");
            return false;
        }
        System.out.println("2");
        return true;
    }
    
    public boolean updateProperty() {
        try {
            propertyFacade.edit(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteProperty() {
        try {
            property.setDeleted(true);
            propertyFacade.edit(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public ORB_Property findPropertyById() {
        return propertyFacade.find(propertyId);
    }

    public List<ORB_Property> findAllProperties() {
        return propertyFacade.findAll();
    }
    
    public List<ORB_Property> findPropertyByLocation() {
        return propertyFacade.findPropertyByLocation(locationController.findLocationByName(location).getId());
    }
    
    public List<ORB_Property> findPropertyByLocation(List<ORB_Property> list) {
        return propertyFacade.findPropertyByLocation(list, locationController.findLocationByName(location).getId());
    }

    public List<ORB_Property> findPropertyByType(List<ORB_Property> list) {
        return propertyFacade.findPropertyByType(list, typeController.findTypeByName(type).getId());
    }

    public List<ORB_Property> findPropertyByNumberOfBedrooms(List<ORB_Property> list) {
        return propertyFacade.findPropertyByNumberOfBedrooms(list, number);
    }

    public List<ORB_Property> findPropertyByNumberOfBathrooms(List<ORB_Property> list) {
        return propertyFacade.findPropertyByNumberOfBathrooms(list, number);
    }

    public List<ORB_Property> findPropertyByMinimumRent(List<ORB_Property> list) {
        return propertyFacade.findPropertyByMinimumRent(list, minRent);
    }

    public List<ORB_Property> findPropertyByMaximumRent(List<ORB_Property> list) {
        return propertyFacade.findPropertyByMaximumRent(list, maxRent);
    }
    
    public void searchProperties() {
        List<ORB_Property> result = new ArrayList<>();
        result = findAllProperties();
        if (location != null) {
            result = findPropertyByLocation(result);
        }
        if (type != null) {
            result = findPropertyByType(result);
        }
        if (bedroomsNumber > 0) {
            result = findPropertyByNumberOfBedrooms(result);
        }
        if (bathroomsNumber > 0) {
            result = findPropertyByNumberOfBathrooms(result);
        }
        if (minRent >= 0) {
            result = findPropertyByMinimumRent(result);
        }
        if (maxRent > 0) {
            result = findPropertyByMaximumRent(result);
        }
        if (result != null) {
            resultsList = result;
            showResults = true;
            noResults = false;
        }
    }
    
}
