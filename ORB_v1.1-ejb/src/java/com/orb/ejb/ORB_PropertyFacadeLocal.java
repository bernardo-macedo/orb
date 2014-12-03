/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

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
    
    void AddProperty (ORB_Property property);

    void UpdateProperty (ORB_Property property);

    void DeleteProperty (ORB_Property property);
    
    List<ORB_Property> FindPropertyByLocation ();

    List<ORB_Property> FindPropertyByType (String type);

    List<ORB_Property> FindPropertyByNumberOfBedrooms (int number);

    List<ORB_Property> FindPropertyByNumberOfBathrooms (int number);

    List<ORB_Property> FindPropertyByMinimumRent (Float minRent);

    List<ORB_Property> FindPropertyByMaximumRent (Float maxRent);
    
}
