/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.maxencelaurent.javapaths;

import org.junit.jupiter.api.Test;

/**
 *
 * @author maxence
 */
public class MainTest {

    public MainTest() {
    }

    @Test
    public void testSomeMethod() {
        Main main = new Main();
        try {
            main.testPath();
        } catch (Exception ex) {
            System.err.println("Ex: " + ex);
        }
        try {
            main.testPathUri();
        } catch (Exception ex) {
            System.err.println("Ex: " + ex);
        }
    }

}
