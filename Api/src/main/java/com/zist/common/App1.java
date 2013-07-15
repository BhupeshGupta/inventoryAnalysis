package com.zist.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zist.controller.MachineController;
import com.zist.controller.SampleController;
import com.zist.controller.StyleController;
import com.zist.controller.YarnController;
import com.zist.utils.ResponseMap;


public class App1 {

	public static void main(String[] args) {

	final String sampleCode = "A0874";
	final String styleCode1 = "S01";
	final String styleCode2 = "S02";
	final String machineCode1 = "M01";
	final String machineCode2 = "M02";
	final String machineCode3 = "M03";
	final String yarnCode1 = "Y03";
	final String yarnCode2 = "Y04";
	
	
	System.out.println("Execution started!!");
	ApplicationContext appcontext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

	MachineController machineController = (MachineController) appcontext.getBean("machineController");
	SampleController sampleController = (SampleController) appcontext.getBean("sampleController");
	YarnController yarnController = (YarnController) appcontext.getBean("yarnController");
	StyleController styleController = (StyleController) appcontext.getBean("styleController");

		
	ResponseMap response;
	
	
	// Machine Creations
	
	response = (ResponseMap) machineController.createMachine(machineCode1, "2.1");
	System.out.println("Creating Machine (Valid) :"+response + "\n\n");
	
	response = (ResponseMap) machineController.createMachine(machineCode2, "3.2");
	System.out.println("Creating Machine (Valid) :"+response + "\n\n");
	
	response = (ResponseMap) machineController.createMachine(machineCode3, "2.1");
	System.out.println("Creating Machine (Valid) :"+response + "\n\n");
	
	response = (ResponseMap) machineController.getMachine(machineCode1);
	System.out.println("Finding Machine (Valid):" + response +"\n\n");
	
	//Style Creations
		
	styleController.createStyle(styleCode1, "Check");
	System.out.println("Creating Style (Valid ) :"+response + "\n\n");
	
	styleController.createStyle(styleCode2, "Stripes");
	System.out.println("Creating Style (Valid) :"+response + "\n\n");
	
	
	//Yarn Creation
	
	response = (ResponseMap) yarnController.createYarn(yarnCode1, "0.2", "Cotton", "100.0");
	System.out.println("Creating Yarn (Valid) :"+response + "\n\n");
	
	response = (ResponseMap) yarnController.createYarn(yarnCode2, "0.6", "Viscose", "90.0");
	System.out.println("Creating Yarn (Valid) :"+response + "\n\n");

	response = (ResponseMap) yarnController.createYarn(yarnCode1, "1.2", "Polyester", "70.0");
	System.out.println("Creating Yarn (Valid) :" + response + "\n\n");

	
	String description1 = "M,L,XL Long Large Broche Red,Green";
	
	String description2 = "S,L Short Small none Black,Violet";
	
	
	//Sample Creations
	

	response = (ResponseMap)sampleController.createSample(sampleCode, 
			"Kurtis", "6.9", "2013", "420", "1200", "C", "F:/", "F", styleCode1, "M01,M02", "Y03", description1);
	
	System.out.println("Creating Sample (Invalid because sample already exists) :"+response + "\n\n");
	
	response = (ResponseMap)sampleController.createSample(sampleCode, 
			"Kurtis", "6.9", "2013", "420", "1200", "C", "F:/", "F", styleCode2, "M04,M02", "Y03", description1);
	
	System.out.println("Creating Sample (Invalid Machine does not exist) :"+ response + "\n\n");

	
	response = (ResponseMap)sampleController.createSample(sampleCode, 
			"Kurtis", "6.9", "2013", "420", "1200", "C", "F:/", "F", styleCode1, "M01,M02", "Y01,Y05", description2);
	
	System.out.println("Creating Sample (Invalid Yarn does not exist) :"+response + "\n\n");
	

	//Sample Updation
	
	response = (ResponseMap)sampleController.updateSample(sampleCode, 
			"Kurtis", "6.9", "2012", "4020", "1200", "C", "F:/", "F", styleCode1, "M01,M02", "Y01,Y05", description1);
	
	System.out.println("Updating Sample (Invalid due to yarn) :  "+ response +"\n\n");
	
	response = (ResponseMap)sampleController.updateSample(sampleCode, 
			"Kurtis", "6.9", "2012", "4020", "1200", "C", "F:/", "F", styleCode1, "M01,M02", "Y03,Y04", description2);
	
	System.out.println("Updating Sample (Valid) :  "+ response +"\n\n");

	
	//Machine Updation
	
	response = (ResponseMap)machineController.updateMachine(machineCode2, "3.6");
	System.out.println("Updating Machine ( Gauge updated )" + response + "\n\n");
	
	//Sample Deletion 
	
	response = (ResponseMap) sampleController.deleteSample(sampleCode);
	System.out.println("Deleting Sample ( Valid )" + response + "\n\n");
	
	response = (ResponseMap) sampleController.deleteSample(styleCode1);
	System.out.println("Deleting Sample (Invalid does not exist)" + response + "\n\n");

	
	    System.out.println("Done!!");
    }
}
