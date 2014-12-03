/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Location;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RenataCristina
 */
@Stateless
public class ORB_LocationFacade extends AbstractFacade<ORB_Location> implements ORB_LocationFacadeLocal {
    @PersistenceContext(unitName = "ORB_v1.1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORB_LocationFacade() {
        super(ORB_Location.class);
    }
    
    @Override
    public ORB_Location findLocationByName(String name) {
        try {
            ORB_Location location = (ORB_Location) em.createQuery("SELECT l FROM ORB_Location l WHERE l.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();
            return location;
        } catch (Exception e) {
        }
        return null;  
    }
    
}
