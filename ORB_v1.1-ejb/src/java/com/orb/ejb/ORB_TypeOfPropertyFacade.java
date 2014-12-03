/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_TypeOfProperty;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RenataCristina
 */
@Stateless
public class ORB_TypeOfPropertyFacade extends AbstractFacade<ORB_TypeOfProperty> implements ORB_TypeOfPropertyFacadeLocal {
    @PersistenceContext(unitName = "ORB_v1.1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORB_TypeOfPropertyFacade() {
        super(ORB_TypeOfProperty.class);
    }
    
}
