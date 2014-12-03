/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_VisitHistory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RenataCristina
 */
@Local
public interface ORB_VisitHistoryFacadeLocal {

    void create(ORB_VisitHistory oRB_VisitHistory);

    void edit(ORB_VisitHistory oRB_VisitHistory);

    void remove(ORB_VisitHistory oRB_VisitHistory);

    ORB_VisitHistory find(Object id);

    List<ORB_VisitHistory> findAll();

    List<ORB_VisitHistory> findRange(int[] range);

    int count();
    
    List<ORB_VisitHistory> findHistoryByPeriod(Long ownerId, int startYear, int startMonth, int endYear, int endMonth);
    
}
