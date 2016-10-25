package com.nhanvo.LooselyCoupled.Directly;

import com.nhanvo.LooselyCoupled.model.CsvOutputGenerator;
import com.nhanvo.LooselyCoupled.model.IOutputGenerator;
import com.nhanvo.LooselyCoupled.model.JsonOutputGenerator;

/**
 * This application resole prolem when you want export two file type: CSV & JSON
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IOutputGenerator output = new CsvOutputGenerator();
        output.generateOutput();
        
        output = new JsonOutputGenerator();
        output.generateOutput();
    }
}
