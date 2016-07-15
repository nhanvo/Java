/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhanvo.abstractfactory;

import com.nhanvo.base.Computer;

/**
 *
 * @author nhanvo
 */
public class AbsComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
            return factory.createComputer();
    }
}
