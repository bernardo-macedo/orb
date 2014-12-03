/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Location;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RenataCristina
 */
@Local
public interface ORB_LocationFacadeLocal {

    void create(ORB_Location oRB_Location);

    void edit(ORB_Location oRB_Location);

    void remove(ORB_Location oRB_Location);

    ORB_Location find(Object id);

    List<ORB_Location> findAll();

    List<ORB_Location> findRange(int[] range);

    int count();
    
}
