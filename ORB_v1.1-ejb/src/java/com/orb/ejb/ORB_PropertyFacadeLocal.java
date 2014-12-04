/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Location;
import com.orb.entities.ORB_Property;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RenataCristina
 */
@Local
public interface ORB_PropertyFacadeLocal {

    void create(ORB_Property oRB_Property);

    void edit(ORB_Property oRB_Property);

    void remove(ORB_Property oRB_Property);

    ORB_Property find(Object id);

    List<ORB_Property> findAll();

    List<ORB_Property> findRange(int[] range);

    int count();

    List<ORB_Property> findPropertyByOwner(Long ownerId);

    List<ORB_Property> findPropertyByLocation(Long locationId);
    
    List<ORB_Property> findPropertyByLocation(List<ORB_Property> list, Long locationId);

    List<ORB_Property> findPropertyByType(List<ORB_Property> list, Long typeId);

    List<ORB_Property> findPropertyByNumberOfBedrooms(List<ORB_Property> list, int number);

    List<ORB_Property> findPropertyByNumberOfBathrooms(List<ORB_Property> list, int number);

    List<ORB_Property> findPropertyByMinimumRent(List<ORB_Property> list, double minRent);

    List<ORB_Property> findPropertyByMaximumRent(List<ORB_Property> list, double maxRent);

}
