/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Photo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RenataCristina
 */
@Local
public interface ORB_PhotoFacadeLocal {

    void create(ORB_Photo oRB_Photo);

    void edit(ORB_Photo oRB_Photo);

    void remove(ORB_Photo oRB_Photo);

    ORB_Photo find(Object id);

    List<ORB_Photo> findAll();

    List<ORB_Photo> findRange(int[] range);

    int count();
    
}
