/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Reference from: http://www.journaldev.com/1392/factory-design-pattern-in-java
 */
package com.nhanvo.factory;

/**
 *
 * @author nhanvo
 */
public class ComputerFactory {
    // Static method, can call directly then not need new instance
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if("PC".equalsIgnoreCase(type)) 
            return new PC(ram, hdd, cpu);
        
        else if ("Server".equalsIgnoreCase(type)) 
            return new Server(ram, hdd, cpu);
        
        return null;
    }
}
