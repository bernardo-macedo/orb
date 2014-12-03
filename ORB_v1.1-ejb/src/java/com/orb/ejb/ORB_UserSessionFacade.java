/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_UserSession;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author -Bernardo
 */
@Stateless
public class ORB_UserSessionFacade extends AbstractFacade<ORB_UserSession> implements ORB_UserSessionFacadeLocal {
    @PersistenceContext(unitName = "ORB_v1.1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORB_UserSessionFacade() {
        super(ORB_UserSession.class);
    }
    
}
