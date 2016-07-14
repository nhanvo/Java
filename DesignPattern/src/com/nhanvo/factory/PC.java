/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhanvo.factory;

/**
 *
 * @author nhanvo
 */
public class PC extends Computer{
    // Data member
    private final String m_Ram;
    private final String m_Hdd;
    private final String m_Cpu;
    
    // Constructor
    public PC(String ram, String hdd, String cpu) {
        this.m_Ram  = ram;
        this.m_Hdd = hdd;
        this.m_Cpu  = cpu;
    }

    /*
     * Override from Computer abstract class
     */
    @Override
    public String getRAM() {
        return this.m_Ram;
    }

    @Override
    public String getHDD() {
        return this.m_Hdd;
    }

    @Override
    public String getCPU() {
        return this.m_Cpu;
    }   
}