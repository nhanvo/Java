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
public abstract class Computer {

    // Abstract method
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();
    
    // Override from Object
    @Override
    public String toString() {
        return " RAM = " + this.getRAM() + " HDD = " + this.getHDD() + " CPU = " + this.getCPU();
    }
}
