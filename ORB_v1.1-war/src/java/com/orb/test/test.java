/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.test;

import com.orb.controllers.UserController;

/**
 *
 * @author -Bernardo
 */
public class test {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.addUser();
        System.out.println("created");
    }
}
