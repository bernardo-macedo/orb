/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_UserSession;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author -Bernardo
 */
@Local
public interface ORB_UserSessionFacadeLocal {

    void create(ORB_UserSession oRB_UserSession);

    void edit(ORB_UserSession oRB_UserSession);

    void remove(ORB_UserSession oRB_UserSession);

    ORB_UserSession find(Object id);

    List<ORB_UserSession> findAll();

    List<ORB_UserSession> findRange(int[] range);

    int count();
    
}
