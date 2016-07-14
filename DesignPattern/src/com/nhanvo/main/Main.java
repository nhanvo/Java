/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Reference from: http://www.journaldev.com/1392/factory-design-pattern-in-java
 */
package com.nhanvo.main;

import com.nhanvo.factory.ComputerFactory;
import com.nhanvo.factory.Computer;

/**
 *
 * @author nhanvo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Factory test        
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        
        showFactory("PC", pc);
        showFactory("SERVER", server);
    }
    
    static void showFactory(String name, Computer com) {
        if (null != com && !name.equals("")) {
            System.out.println("Factory " + name + " config: " + com);
        } else {
            System.out.println("Failed when init object from computer factory");
        }
    }
}
