package com.zist.common;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zist.controller.MachineController;
import com.zist.controller.SampleController;
import com.zist.controller.StyleController;
import com.zist.controller.YarnController;
import com.zist.model.Sample;
import com.zist.utils.ResponseMap;


public class App1 {

	public static void main(String[] args) {

	final String sampleCode1 = "A01";
	final String sampleCode2 = "A02";
	final String sampleCode3 = "A03";
	final String sampleCode4 = "A04";
	final String sampleCode5 = "A05";
	final String styleCode1 = "S01";
	final String styleCode2 = "S02";
	final String styleCode3 = "S03";
	final String machineCode1 = "M01";
	final String machineCode2 = "M02";
	final String machineCode3 = "M03";
	final String yarnCode1 = "Y01";
	final String yarnCode2 = "Y02";
	final String yarnCode3 = "Y03";
	final String yarnCode4 = "Y04";
	final String description1 = "M,L,XL Long Large Broche Red,Green";
	final String description3 = "S,L,XL,XXXL Short Small none Black,Violet";	
	
	System.out.println("Execution started!!");
	ApplicationContext appcontext = new ClassPathXmlApplicationContext("applicationContext.xml");

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
	
	response = (ResponseMap) machineController.createMachine(machineCode3, "4.1");
	System.out.println("Creating Machine (Valid) :"+response + "\n\n");
	
	response = (ResponseMap) machineController.getMachine(machineCode1);
	System.out.println("Finding Machine (Valid):" + response +"\n\n");
	
	//Style Creations
		
	styleController.createStyle(styleCode1, "Check");
	System.out.println("Creating Style (Valid ) :"+response + "\n\n");
	
	styleController.createStyle(styleCode2, "Stripes");
	System.out.println("Creating Style (Valid) :"+response + "\n\n");
	
	styleController.createStyle(styleCode3, "Cables");
	System.out.println("Creating Style (Valid) :"+response + "\n\n");
	
	//Yarn Creation
	
	response = (ResponseMap) yarnController.createYarn(yarnCode1, "0.2", "Cotton", "100.0");
	System.out.println("Creating Yarn (Valid) :"+response + "\n\n");
	
	response = (ResponseMap) yarnController.createYarn(yarnCode2, "0.6", "Viscose", "90.0");
	System.out.println("Creating Yarn (Valid) :"+response + "\n\n");

	response = (ResponseMap) yarnController.createYarn(yarnCode3, "1.2", "Polyester", "70.0");
	System.out.println("Creating Yarn (Valid) :" + response + "\n\n");

	response = (ResponseMap) yarnController.createYarn(yarnCode4, "5.2", "Cotton", "120.0");
	System.out.println("Creating Yarn (Valid) :"+response + "\n\n");
	
	//Sample Creations
	

	response = (ResponseMap)sampleController.createSample(sampleCode1, 
			"Kurtis", "7.9", "2013", "520", "1200", "C", "F:/", "F", styleCode1, "M01,M02", "Y02", description1);
	
	System.out.println("Creating Sample (Invalid because sample already exists) :"+response + "\n\n");
	
	response = (ResponseMap)sampleController.createSample(sampleCode2, 
			"Kurtis", "8.9", "2013", "420", "1000", "C", "F:/", "F", styleCode2, "M03,M02", "Y03", description1);
	
	System.out.println("Creating Sample (Valid) :"+ response + "\n\n");

	
	response = (ResponseMap)sampleController.createSample(sampleCode3, 
			"Kurtis", "6.0", "2011", "220", "800", "C", "F:/", "F", styleCode1, "M01", "Y01,Y04", description3);
	
	System.out.println("Creating Sample (Valid) :"+response + "\n\n");
	
	response = (ResponseMap)sampleController.createSample(sampleCode4, 
			"Kurtis", "6.0", "2014", "220", "800", "C", "F:/", "M", styleCode3, "M02", "Y01", description3);
	
	System.out.println("Creating Sample (Valid) :"+response + "\n\n");

	response = (ResponseMap)sampleController.createSample(sampleCode5, 
			"Kurtis", "6.0", "2015", "220", "800", "C", "F:/", "M", styleCode2, "M01,M03", "Y01,Y03,Y04",
			description1);
	
	System.out.println("Creating Sample (Valid) :"+response + "\n\n");
	
	//Machine Updation
	
	response = (ResponseMap)machineController.updateMachine(machineCode2, "3.6");
	System.out.println("Updating Machine ( Gauge updated )" + response + "\n\n");
	
	// Searching a machine

	response = (ResponseMap)machineController.searchMachine(machineCode1, "", "","");
	System.out.println("Search Machine ( valid 1 result)" + response + "\n\n");
	
	response = (ResponseMap)machineController.searchMachine("","2","4","");
	System.out.println("Search Machine between 2 and 4 ( valid 2 results)" + response + "\n\n");

	response = (ResponseMap)machineController.searchMachine("", "10", "","");
	System.out.println("Search Machine having gauge greater than 10 ( No Result)" + response + "\n\n");
	
	// Searching a yarn 
	
	response = (ResponseMap)yarnController.searchYarn(yarnCode3, "", "", "", "", "", "", "");
	System.out.println("Searching Yarn with yarn code Y03(Valid 1 Yarn Found )" + response + "\n\n");
	
	response = (ResponseMap)yarnController.searchYarn("", "0.1", "0.6", "", "", "", "", "");
	System.out.println("Searching Yarn having yarn count between 01 and 0.6(Valid 2 Yarn Found )" + response + "\n\n");

	response = (ResponseMap)yarnController.searchYarn("", "", "", "0.6", "", "", "", "");
	System.out.println("Searching Yarn having yarnCount = 0.6 (Valid 1 Yarn Found )" + response + "\n\n");

	response = (ResponseMap)yarnController.searchYarn("", "", "", "", "Cotton", "", "", "");
	System.out.println("Searching Yarn having type Count (Valid 1 Yarn Found )" + response + "\n\n");
	
	response = (ResponseMap)yarnController.searchYarn("", "", "", "", "COTTON","", "", "");
	System.out.println("Searching Yarn (Valid 1 Yarn Found )" + response + "\n\n");


	// Searching a style
	response = (ResponseMap)styleController.searchStyle(styleCode3, "");
	System.out.println("Searching Style (Valid 1 result)" + response + "\n\n");
	

	// Searching a sample
	
	response = (ResponseMap)sampleController.searchSample(sampleCode1, "", "","","","",
			"", "", "", "", "", "","","","", "","","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");
	

	response = (ResponseMap)sampleController.searchSample("", "Kurtis", "","","","",
			"", "", "", "", "", "","","","", "","","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");
	
	
	response = (ResponseMap)sampleController.searchSample("", "", "6","7.9","","",
			"", "", "", "", "", "","","","", "","","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");

	
	response = (ResponseMap)sampleController.searchSample("", "", "","","","2012",
			"2014", "", "", "", "", "","","","", "","","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");

	response = (ResponseMap)sampleController.searchSample("", "", "","","","",
			"", "2013", "", "", "", "","","","", "","","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");

	response = (ResponseMap)sampleController.searchSample("", "", "","","","",
			"", "", "", "", "", "","","","M", "","","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");

	response = (ResponseMap)sampleController.searchSample("", "", "","","","",
			"", "", "", "", "", "","","","F", "","","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");

	response = (ResponseMap)sampleController.searchSample("", "", "","","","",
			"", "", "", "", "", "","","","", styleCode2,"","");
	System.out.println("Searching Sample (Valid 1 result)" + response + "\n\n");

	response = (ResponseMap)sampleController.searchSample("", "", "","","","",
			"", "", "", "", "", "","","","","",machineCode1,"");
	System.out.println("Searching Sample (Valid 3 results A01,A03,A05)" + response + "\n\n");

	response = (ResponseMap)sampleController.searchSample("", "", "","","","",
			"", "", "", "", "", "","","","","",(machineCode1+","+machineCode2),"");
	System.out.println("Searching Sample (Valid 1 result for A01)" + response + "\n\n");

	response = (ResponseMap)sampleController.searchSample("", "", "","","","",
			"", "", "", "", "", "","","","","",machineCode2,yarnCode1);
	System.out.println("Searching Sample (Valid 1 result for A04)" + response + "\n\n");

	//Testing Getall Functions
	
	response = (ResponseMap)sampleController.getAllSamples();
	System.out.println("Get all samples (Valid)"+response+"\n\n");

	@SuppressWarnings("unchecked")
	ArrayList<Sample> sampleList = (ArrayList<Sample>) response.get("sampleList");
	System.out.println("\n\n"+sampleList.size()+"\n\n");
	response = (ResponseMap) machineController.getAllMachines();
	System.out.println("Get all machines (Valid)"+response+"\n\n");
	
	response = (ResponseMap) yarnController.getAllYarns();
	System.out.println("Get all yarns (Valid)"+response+"\n\n");
	
	response = (ResponseMap)styleController.getAllStyles();
	System.out.println("Get all styles (Valid)"+response+"\n\n");
	//Sample Deletion 
	
	response = (ResponseMap) sampleController.deleteSample(sampleCode1);
	System.out.println("Deleting Sample ( Valid )" + response + "\n\n");
	
	response = (ResponseMap) sampleController.deleteSample(styleCode1);
	System.out.println("Deleting Sample (Invalid does not exist)" + response + "\n\n");
	
	System.out.println("Done!!");
    

	}
}
