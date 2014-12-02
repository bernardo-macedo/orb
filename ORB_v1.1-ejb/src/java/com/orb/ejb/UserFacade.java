/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author -Bernardo
 */
@Stateless
public class UserFacade extends AbstractFacade<ORB_User> implements UserFacadeLocal {
    @PersistenceContext(unitName = "ORB_v1.1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(ORB_User.class);
    }
    
    @Override
    public boolean isUsernameAlreadyRegistered(String username) {
        boolean result = true;
        try {
            findByUsername(username);
        } catch(NoResultException e) {
            result = false;
        }
        return result;
    }
    
    @Override
    public ORB_User findByEmail(String email) {
        return (ORB_User) em.createQuery("SELECT u FROM ORB_User u WHERE u.email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }
    
    @Override
    public ORB_User findByUsername(String username) {
        return (ORB_User) em.createQuery("SELECT u FROM ORB_User u WHERE u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }
}
