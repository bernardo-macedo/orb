/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.persistence;

import com.orb.entities.ORB_User;
import com.orb.util.PasswordHash;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author -Bernardo
 */
public class UserListener {
    
    @PrePersist
    public void onPrePersist(ORB_User user) {
        try {
            // Hash user password
            user.setPassword(PasswordHash.createHash(user.getPassword()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Set 'deleted' property as false
        user.setDeleted(false);
    }
    
    @PreUpdate
    public void onPreUpdate(ORB_User user) {
        try {
            // Hash user password
            user.setPassword(PasswordHash.createHash(user.getPassword()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Set 'deleted' property as false
        user.setDeleted(false);
    }
}
