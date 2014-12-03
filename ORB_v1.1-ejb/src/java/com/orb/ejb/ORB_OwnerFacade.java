/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Owner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RenataCristina
 */
@Stateless
public class ORB_OwnerFacade extends AbstractFacade<ORB_Owner> implements ORB_OwnerFacadeLocal {
    @PersistenceContext(unitName = "ORB_v1.1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORB_OwnerFacade() {
        super(ORB_Owner.class);
    }
    
}
