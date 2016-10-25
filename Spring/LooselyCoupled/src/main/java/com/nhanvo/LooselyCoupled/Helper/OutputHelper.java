package com.nhanvo.LooselyCoupled.Helper;

import com.nhanvo.LooselyCoupled.model.CsvOutputGenerator;
import com.nhanvo.LooselyCoupled.model.IOutputGenerator;

public class OutputHelper {
	IOutputGenerator output;
	
	public OutputHelper() {
		output = new CsvOutputGenerator();
	}
	
	public void generateOutput(){
		output.generateOutput();
	}
}
