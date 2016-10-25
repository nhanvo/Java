package com.nhanvo.LooselyCoupled.Spring;

import com.nhanvo.LooselyCoupled.model.IOutputGenerator;

public class OutputHelper {
	IOutputGenerator outputGenerator;

	public void generateOutput(){
		outputGenerator.generateOutput();
	}

	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}
}
