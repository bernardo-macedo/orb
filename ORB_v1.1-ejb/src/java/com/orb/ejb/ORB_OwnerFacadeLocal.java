/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Owner;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RenataCristina
 */
@Local
public interface ORB_OwnerFacadeLocal {

    void create(ORB_Owner oRB_Owner);

    void edit(ORB_Owner oRB_Owner);

    void remove(ORB_Owner oRB_Owner);

    ORB_Owner find(Object id);

    List<ORB_Owner> findAll();

    List<ORB_Owner> findRange(int[] range);

    int count();
    
}
