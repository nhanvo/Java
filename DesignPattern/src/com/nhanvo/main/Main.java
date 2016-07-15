/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Reference from: http://www.journaldev.com/1392/factory-design-pattern-in-java
 */
package com.nhanvo.main;

import com.nhanvo.abstractfactory.PCFactory;
import com.nhanvo.abstractfactory.ServerFactory;
import com.nhanvo.abstractfactory.AbsComputerFactory;
import com.nhanvo.factory.ComputerFactory;
import com.nhanvo.base.Computer;

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
        System.out.println("TEST METHOD FACTORY");
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        
        showFactory("PC", pc);
        showFactory("SERVER", server);
        
        // Abstract Factory
        System.out.println("TEST ABSTRACT FACTORY");
        pc = AbsComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        server = AbsComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        
        System.out.println("Abstract Factory PC: " + pc);
        System.out.println("Abstract Factory Server: " + server);
    }
    
    static void showFactory(String name, Computer com) {
        if (null != com && !name.equals("")) {
            System.out.println("Factory " + name + " config: " + com);
        } else {
            System.out.println("Failed when init object from computer factory");
        }
    }
}
