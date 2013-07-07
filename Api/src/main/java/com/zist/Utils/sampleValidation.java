package com.zist.Utils;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.zist.dao.StyleDao;
import com.zist.model.Description;
import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;
import com.zist.service.DescriptionService;
import com.zist.service.MachineService;
import com.zist.service.StyleService;
import com.zist.service.YarnService;
import com.zist.util.ResponseMap;

public class sampleValidation {
	public static Sample validateSampleAndGetSample(ResponseMap response,
			String sampleCode, String category, Float popularity, String year,
			Float weight, Float price, String view, String designFile,
			String gender, String styleID, String[] machineIDs, String[] yarns,
			String descriptionID) {

		@Autowired
		StyleService styleService;
		@Autowired
		MachineService machineService;
		@Autowired
		YarnService yarnService;
		@Autowired
		DescriptionService descriptionService;
		
		Style style;
		Set<Machine> machines;
		Set<Yarn> yarn;
		Description description;

		int validatedYear;
		int validatedStyleID;
		int validatedDescriptionID;
		
		// TODO: Get parameters, validate and plug it in sample entity

		// TODO: category validation

		if (popularity > 10 || popularity < 0) {
			response.setError("Invalid Input.Popularity should be between 0 and 10");
			return null;
		}

		try {
			validatedYear = Integer.parseInt(year);

		} catch (NumberFormatException e) {
			response.setError("Invalid input please enter a numeric year");
			return null;
		}

		if (validatedYear < 1900 || validatedYear > 3000) {
			response.setError("Invalid input please enter a valid year");
			return null;
		}

		if (weight < 0) {
			response.setError("Invalid input please enter a valid weight");
			return null;
		}

		if (price < 0) {
			response.setError("Invalid input please enter a valid price");
			return null;
		}

		try {
			validatedStyleID = Integer.parseInt(styleID);
			style = styleService.findByStyleCode(styleID);
		} catch (NumberFormatException e) {
			response.setError("Invalid input please enter a Valid Style code");
			return null;
		}
		// TODO: view and designfile validation

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

		for (int i = 0; i < machineIDs.length; i++) {
			Machine machine = machineService.findByMachineCode(machineIDs[i]);
			if (machine == null) {
				response.setError("Invalid input, machine (" + i
						+ ") Does not Exist");
				return null;
			} else {
				machines.add(machine);
			}
		}

		for (int i = 0; i < yarns.length; i++) {
			Yarn temp_yarn = yarnService.findByYarnCode(yarns[i]);
			if (temp_yarn == null) {
				response.setError("Invalid input, yarn (" + i
						+ ") Does not Exist");
				return null;
			} else {
				yarn.add(temp_yarn);
			}
		}

		// TODO: Check Description validation
		
		
		Sample sample = new Sample();

		sample.setSampleCode(sampleCode);
		sample.setPopularity(popularity);
		sample.setGender(gender);
		sample.setYear(year);
		sample.setWeight(weight);
		sample.setPrice(price);
		sample.setStyle(style);
		sample.setMachines(machines);
		sample.setYarn(yarn);
		// TODO: Description setting
		
		return sample;
	}
}
