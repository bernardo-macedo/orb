/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.persistence;

import com.orb.entities.ORB_Rent;
import java.util.Calendar;
import javax.persistence.PrePersist;

/**
 *
 * @author -Bernardo
 */
public class RentListener {
    @PrePersist
    public void onPrePersist(ORB_Rent rent) {
        // Set creation timestamp as the current time, if not yet set
        if (rent.getRentedTimeStamp() == null) {
            rent.setRentedTimeStamp(Calendar.getInstance());
        }
    }
}
