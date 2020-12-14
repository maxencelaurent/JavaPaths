/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.maxencelaurent.javapaths;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author maxence
 */
public class Main {

    private static final String srcPath = "com/github/maxencelaurent/javapaths/Main.class";

    public void testPath() {
        String currentPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("CurrentPath: " + currentPath);
        Path get = Paths.get(currentPath, srcPath);
        System.out.println("Get " + get);
    }

    public void testPathUri() throws URISyntaxException {
        URL currentPath = getClass().getProtectionDomain().getCodeSource().getLocation();
        System.out.println("CurrentPathURL: " + currentPath);
        Path get = Paths.get(currentPath.toURI());
        System.out.println("toUri.toPath " + get);
    }

    public static void main(String... argv) {
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
