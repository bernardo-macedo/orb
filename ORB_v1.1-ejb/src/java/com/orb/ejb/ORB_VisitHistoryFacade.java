/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_Property;
import com.orb.entities.ORB_VisitHistory;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RenataCristina
 */
@Stateless
public class ORB_VisitHistoryFacade extends AbstractFacade<ORB_VisitHistory> implements ORB_VisitHistoryFacadeLocal {
    @PersistenceContext(unitName = "ORB_v1.1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORB_VisitHistoryFacade() {
        super(ORB_VisitHistory.class);
    }
    
    @Override
    public List<ORB_VisitHistory> findHistoryByPeriod(Long ownerId, int startYear, int startMonth, int endYear, int endMonth) {
        try {
            List<ORB_Property> propertiesList = em.createQuery("SELECT p FROM ORB_Property p WHERE p.owner = :ownerId AND p.deleted = :false")
                    .setParameter("ownerId", ownerId)
                    .setParameter("false", false)
                    .getResultList();
            List<ORB_VisitHistory> resultList = null;
            List<ORB_VisitHistory> auxList = null;
            if (propertiesList != null) {
                for (ORB_Property property : propertiesList) {
                auxList = em.createQuery("SELECT h FROM ORB_VisitHistory h WHERE h.property = :propertyId "
                        + "AND h.year_period >= :startYear AND h.year_period <= :endYear AND (h.month_period >= :startMonth OR h.month_period <= :endMonth)")
                        .setParameter("propertyId", property.getId())
                        .setParameter("startYear", startYear)
                        .setParameter("endYear", endYear)
                        .setParameter("startMonth", startMonth)
                        .setParameter("endMonth", endMonth)
                        .getResultList();
                if (auxList != null) {
                    for(ORB_VisitHistory item : auxList) {
                        resultList.add(item);
                    }
                }
            }
            return resultList;
            }
        } catch (Exception e) {
        }
        return null;
    }

}
