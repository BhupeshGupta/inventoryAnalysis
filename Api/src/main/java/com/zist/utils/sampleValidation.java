package com.zist.utils;


import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zist.model.Description;
import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;
import com.zist.service.DescriptionService;
import com.zist.service.MachineService;
import com.zist.service.SampleService;
import com.zist.service.StyleService;
import com.zist.service.YarnService;



public class sampleValidation {


	static ApplicationContext appcontext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

	static SampleService sampleService = (SampleService) appcontext.getBean("sampleService");
	static StyleService styleService = (StyleService) appcontext.getBean("styleService");
	static MachineService machineService = (MachineService) appcontext.getBean("machineService");;
	static YarnService yarnService = (YarnService) appcontext.getBean("yarnService");;
	static DescriptionService descriptionService = (DescriptionService) appcontext.getBean("descriptionService");

	
	public static Sample validateSampleAndGetSample(ResponseMap response,
			String sampleCode, String category, String popularity, String year,
			String weight, String price, String view, String designFile,
			String gender, String styleCode, String[] machineCodes, String[] yarnCodes,
			String[] sizeDescription,String buttonStyle,String buttonSize,String[] accessories,
			String[] color) {

		
		Float validatedPopularity;
		int   validatedYear;
		Float validatedWeight;
		Float validatedPrice;
		String descriptionJason ;
		
		Style style = null;
		Set<Machine> machines = new HashSet<Machine>();
		Set<Yarn> yarn = new HashSet<Yarn>();
		
		// TODO: Get parameters, validate and plug it in sample entity

		// TODO: category validation

		// Popularity Validation
		
		try{
			validatedPopularity = Float.parseFloat(popularity);
			if (validatedPopularity > 10 || validatedPopularity < 0) {
				response.setError("Invalid Input.Popularity should be between 0 and 10");
				return null;
			}
			
		} catch (NumberFormatException e) {
			response.setError("Invalid input please enter a numeric Popularity");
			return null;
		}
		
		// Year Validation
		
		try {
			validatedYear = Integer.parseInt(year);
			if (validatedYear < 1900 || validatedYear > 3000) {
				response.setError("Invalid input please enter a valid year");
				return null;
			}
		} catch (NumberFormatException e) {
			response.setError("Invalid input please enter a numeric year");
			return null;
		}

		// Weight Validation

		try{
			validatedWeight = Float.parseFloat(weight);
			if (validatedWeight < 0) {
				response.setError("Invalid input please enter a valid weight");
				return null;
			}
		} catch (NumberFormatException e){
			response.setError("Invalid input please enter a numeric weight");
			return null;
		}
		
		//Price Validation

		try{
			validatedPrice = Float.parseFloat(price);
			if (validatedPrice < 0) {
				response.setError("Invalid input please enter a valid price");
				return null;
			}
		} catch (NumberFormatException e){
			response.setError("Invalid input please enter a numeric price");
			return null;
		}

		//Style Validation
		
		try {
			style = styleService.findByStyleCode(styleCode);
			if (style == null){
				response.setError("Style code does not exist");
				return null;				
			}
		} catch (NumberFormatException e) {
			response.setError("Invalid input please enter a Valid Style code");
			return null;
		}
		
		// TODO: view and designfile validation

		// Gender Validation
		
		gender = gender.toUpperCase();
		if (gender == "MALE" || gender == "M") {
			gender = "MALE";
		} else if (gender == "FEMALE" || gender == "F") {
			gender = "FEMALE";
		} else {
			response.setStatus("1");
			response.setMessage("Invalid Gender. Choose M/F");
			return null;
		}

		// Machine Validatons
		
		for (int i = 0; i < machineCodes.length; i++) {
			machineCodes[i] = machineCodes[i].toUpperCase();
			Machine machine = machineService.findByMachineCode(machineCodes[i]);
			if (machine == null) {
				response.setError("Invalid input, machine (" + i
						+ ") Does not Exist");
				return null;
			} else {
				machines.add(machine);
			}
		}

		// Yarn Validations
		
		for (int i = 0; i < yarnCodes.length; i++) {
			yarnCodes[i] = yarnCodes[i].toUpperCase();
			Yarn temp_yarn = yarnService.findByYarnCode(yarnCodes[i]);
			if (temp_yarn == null) {
				response.setError("Invalid input, yarn (" + i
						+ ") Does not Exist");
				return null;
			} else {
				yarn.add(temp_yarn);
			}
		}

		// Description Validations

		Description description = new Description(sizeDescription,buttonStyle,buttonSize,accessories,
					color);
		
		descriptionJason = sampleService.getDescriptionJason(description);
			
		Sample sample = new Sample();

		sample.setSampleCode(sampleCode);
		sample.setCategory(category.toUpperCase());
		sample.setPopularity(validatedPopularity);
		sample.setGender(gender);
		sample.setYear(new Float(validatedYear));
		sample.setWeight(validatedWeight);
		sample.setPrice(validatedPrice);
		sample.setStyle(style);
		sample.setMachines(machines);
		sample.setYarn(yarn);
		sample.setDescription(descriptionJason);
		
		return sample;
	}
}
