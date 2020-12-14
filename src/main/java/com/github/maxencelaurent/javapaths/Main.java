/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.maxencelaurent.javapaths;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author maxence
 */
public class Main {

    private static final String srcPath = "src/main/resources/godot.txt";

    public void testPath() throws IOException {
        String currentPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        int indexOf = currentPath.indexOf("/target");
        String root = currentPath.substring(0, indexOf);

        System.out.println("CurrentPath: " + currentPath);
        Path get = Paths.get(root, srcPath);
        System.out.println("Get " + get);
        String readString = Files.readString(get);
        System.out.println(readString);
    }

    public void testPathUri() throws URISyntaxException, MalformedURLException, IOException {
        URL currentPath = getClass().getProtectionDomain().getCodeSource().getLocation();
        String path = currentPath.toString();
        int indexOf = path.indexOf("target");

        String root = path.substring(0, indexOf);
        URL url = new URL(root +srcPath);
        System.out.println("CurrentPathURL: " + currentPath);
        Path get = Paths.get(url.toURI());

        System.out.println("toUri.toPath " + get);

        String readString = Files.readString(get);
        System.out.println(readString);
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
