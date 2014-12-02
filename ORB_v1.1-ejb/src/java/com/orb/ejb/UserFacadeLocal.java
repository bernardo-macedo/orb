/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.ejb;

import com.orb.entities.ORB_User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author -Bernardo
 */
@Local
public interface UserFacadeLocal {

    void create(ORB_User user);

    void edit(ORB_User user);

    void remove(ORB_User user);

    ORB_User find(Object id);

    List<ORB_User> findAll();

    List<ORB_User> findRange(int[] range);

    int count();
    
    ORB_User findByEmail(String email);
    
    ORB_User findByUsername(String username);
    
    boolean isUsernameAlreadyRegistered(String username);
    
}
