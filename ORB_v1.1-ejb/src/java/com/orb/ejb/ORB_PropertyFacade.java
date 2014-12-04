/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Property;
import java.util.ArrayList;
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
    public List<ORB_Property> findPropertyByLocation(List<ORB_Property> list, Long locationId) {
        try {
            List<ORB_Property> resultList = new ArrayList<>();
            ORB_Property aux = new ORB_Property();
            if (list != null) {
                for (ORB_Property property : list) {
                    aux = (ORB_Property) em.createQuery("SELECT p FROM ORB_Property p WHERE p.id = :id AND p.location = :locationId AND p.deleted = false")
                            .setParameter("id", property.getId())
                            .setParameter("locationId", locationId)
                            .getSingleResult();
                    if (aux != null) {
                        resultList.add(aux);
                        aux = null;
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByType(List<ORB_Property> list, Long typeId) {
        try {
            List<ORB_Property> resultList = new ArrayList<>();
            ORB_Property aux = new ORB_Property();
            if (list != null) {
                for (ORB_Property property : list) {
                    aux = (ORB_Property) em.createQuery("SELECT p FROM ORB_Property p WHERE p.id = :id AND p.typeOfProperty = :typeId AND p.deleted = false")
                            .setParameter("id", property.getId())
                            .setParameter("typeId", typeId)
                            .getSingleResult();
                    if (aux != null) {
                        resultList.add(aux);
                        aux = null;
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByNumberOfBedrooms(List<ORB_Property> list, int number) {
        try {
            List<ORB_Property> resultList = new ArrayList<>();
            ORB_Property aux = new ORB_Property();
            if (list != null) {
                for (ORB_Property property : list) {
                    aux = (ORB_Property) em.createQuery("SELECT p FROM ORB_Property p WHERE p.id = :id AND p.bedroomsNumber = :number AND p.deleted = false")
                            .setParameter("id", property.getId())
                            .setParameter("number", number)
                            .getSingleResult();
                    if (aux != null) {
                        resultList.add(aux);
                        aux = null;
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByNumberOfBathrooms(List<ORB_Property> list, int number) {
        try {
            List<ORB_Property> resultList = new ArrayList<>();
            ORB_Property aux = new ORB_Property();
            if (list != null) {
                for (ORB_Property property : list) {
                    aux = (ORB_Property) em.createQuery("SELECT p FROM ORB_Property p WHERE p.id = :id AND p.bathroomsNumber = :number AND p.deleted = false")
                            .setParameter("id", property.getId())
                            .setParameter("number", number)
                            .getSingleResult();
                    if (aux != null) {
                        resultList.add(aux);
                        aux = null;
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByMinimumRent(List<ORB_Property> list, double minRent) {
        try {
            List<ORB_Property> resultList = new ArrayList<>();
            ORB_Property aux = new ORB_Property();
            if (list != null) {
                for (ORB_Property property : list) {
                    aux = (ORB_Property) em.createQuery("SELECT p FROM ORB_Property p WHERE p.id = :id AND p.rent >= :minRent AND p.deleted = false")
                            .setParameter("id", property.getId())
                            .setParameter("minRent", minRent)
                            .getSingleResult();
                    if (aux != null) {
                        resultList.add(aux);
                        aux = null;
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<ORB_Property> findPropertyByMaximumRent(List<ORB_Property> list, double maxRent) {
        try {
            List<ORB_Property> resultList = new ArrayList<>();
            ORB_Property aux = new ORB_Property();
            if (list != null) {
                for (ORB_Property property : list) {
                    aux = (ORB_Property) em.createQuery("SELECT p FROM ORB_Property p WHERE p.id = :id AND p.rent <= :maxRent AND p.deleted = false")
                            .setParameter("id", property.getId())
                            .setParameter("maxRent", maxRent)
                            .getSingleResult();
                    if (aux != null) {
                        resultList.add(aux);
                        aux = null;
                    }
                }
            }
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }
    

}
