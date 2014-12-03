/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Location;
import com.orb.entities.ORB_Property;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RenataCristina
 */
@Stateless
public class ORB_PropertyFacade extends AbstractFacade<ORB_Property> implements ORB_PropertyFacadeLocal {
    @PersistenceContext(unitName = "ORB_v1.1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORB_PropertyFacade() {
        super(ORB_Property.class);
    }

    @Override
    public List<ORB_Property> findPropertyByOwner(Long ownerId) {
        try {
            List<ORB_Property> resultList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.owner = :ownerId")
                    .setParameter("ownerId", ownerId)
                    .getResultList();
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }
    
    @Override
    public List<ORB_Property> findPropertyByLocation(Long locationId) {
        try {
            List<ORB_Property> resultList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.location = :locationId")
                    .setParameter("locationId", locationId)
                    .getResultList();
            if (resultList != null) {
                for (ORB_Property result : resultList) {
                    if (result.isDeleted()) {
                        resultList.remove(result);
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByType(Long typeId) {
        try {
            List<ORB_Property> resultList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.typeOfProperty = :typeId")
                    .setParameter("typeId", typeId)
                    .getResultList();
            if (resultList != null) {
                for (ORB_Property result : resultList) {
                    if (result.isDeleted()) {
                        resultList.remove(result);
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByNumberOfBedrooms(int number) {
        try {
            List<ORB_Property> resultList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.bedroomsNumber = :number")
                    .setParameter("number", number)
                    .getResultList();
            if (resultList != null) {
                for (ORB_Property result : resultList) {
                    if (result.isDeleted()) {
                        resultList.remove(result);
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByNumberOfBathrooms(int number) {
        try {
            List<ORB_Property> resultList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.bathroomsNumber = :number")
                    .setParameter("number", number)
                    .getResultList();
            if (resultList != null) {
                for (ORB_Property result : resultList) {
                    if (result.isDeleted()) {
                        resultList.remove(result);
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByMinimumRent(double minRent) {
        try {
            List<ORB_Property> resultList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.rent >= :minRent")
                    .setParameter("minRent", minRent)
                    .getResultList();
            if (resultList != null) {
                for (ORB_Property result : resultList) {
                    if (result.isDeleted()) {
                        resultList.remove(result);
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByMaximumRent(double maxRent) {
        try {
            List<ORB_Property> resultList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.rent >= :maxRent")
                    .setParameter("maxRent", maxRent)
                    .getResultList();
            if (resultList != null) {
                for (ORB_Property result : resultList) {
                    if (result.isDeleted()) {
                        resultList.remove(result);
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }
    

}
