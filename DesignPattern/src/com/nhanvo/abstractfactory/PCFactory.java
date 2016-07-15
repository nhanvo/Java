/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhanvo.abstractfactory;

import com.nhanvo.base.Computer;
import com.nhanvo.base.PC;

/**
 *
 * @author nhanvo
 */
public class PCFactory implements ComputerAbstractFactory{
    private final String ram;
    private final String hdd;
    private final String cpu;
    
    public PCFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }
    
    @Override
    public Computer createComputer() {
        return new PC(ram, hdd, cpu);
    }
}
