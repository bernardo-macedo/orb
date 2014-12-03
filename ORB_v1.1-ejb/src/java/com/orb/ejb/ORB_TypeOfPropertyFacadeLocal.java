/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_TypeOfProperty;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RenataCristina
 */
@Local
public interface ORB_TypeOfPropertyFacadeLocal {

    void create(ORB_TypeOfProperty oRB_TypeOfProperty);

    void edit(ORB_TypeOfProperty oRB_TypeOfProperty);

    void remove(ORB_TypeOfProperty oRB_TypeOfProperty);

    ORB_TypeOfProperty find(Object id);

    List<ORB_TypeOfProperty> findAll();

    List<ORB_TypeOfProperty> findRange(int[] range);

    int count();
    
}
