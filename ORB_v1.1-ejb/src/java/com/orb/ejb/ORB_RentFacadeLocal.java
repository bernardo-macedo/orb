/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Rent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RenataCristina
 */
@Local
public interface ORB_RentFacadeLocal {

    void create(ORB_Rent oRB_Rent);

    void edit(ORB_Rent oRB_Rent);

    void remove(ORB_Rent oRB_Rent);

    ORB_Rent find(Object id);

    List<ORB_Rent> findAll();

    List<ORB_Rent> findRange(int[] range);

    int count();
    
}
