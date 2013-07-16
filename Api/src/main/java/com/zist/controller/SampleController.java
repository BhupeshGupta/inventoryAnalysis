package com.zist.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.zist.model.Sample;
import com.zist.service.SampleService;
import com.zist.service.SearchService;
import com.zist.utils.ResponseMap;
import com.zist.utils.sampleValidation;

@Controller
public class SampleController {

	@Autowired
	SearchService searchService;
	@Autowired
	SampleService sampleService;
	

	@SuppressWarnings("rawtypes")
	public Map getSample(String sampleCode) {
		ResponseMap response = new ResponseMap();
		Sample sample = sampleService.findBySampleCode(sampleCode);
		if (sample == null) {
			response.setError("Sample Does not exist ");
		} else {
			response.put("sample", sample);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map createSample(String sampleCode, String category,
			String popularity, String year, String weight, String price,
			String view, String designFile, String gender, String styleID,
			String machineIDs, String yarns, String description) {

		ResponseMap response = new ResponseMap();

		String[] tokensMachineIDs = machineIDs.split(",");
		String[] tokensYarnIds = yarns.split(",");
		String[] tokensDescriptionattributes = description.split(" ");
		String[] sizeDescription = tokensDescriptionattributes[0].split(",");
		String   buttonStyle = tokensDescriptionattributes[1];
		String   buttonSize = tokensDescriptionattributes[2];
		String[] accessories = tokensDescriptionattributes[3].split(",");
		String[] color = tokensDescriptionattributes[4].split(",");

		Sample sample = sampleValidation.validateSampleAndGetSample(response,
				sampleCode, category, popularity, year, weight, price, view,
				designFile, gender, styleID, tokensMachineIDs, tokensYarnIds,
				sizeDescription,buttonStyle,buttonSize,accessories,color);

		if (sample == null)
			return response;

		try {
			System.out.println(sample.getDescription() + "\n");
			sampleService.save(sample);
		} catch (DataIntegrityViolationException e) {
			response.setError("Sample already Exist ");
			return response;
		}
		response.put("sample", sample);
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map deleteSample(String sampleCode) {
		ResponseMap response = new ResponseMap();

		Sample sample = sampleService.findBySampleCode(sampleCode);
		if (sample == null) {
			response.setError("Sample Does not exist ");
		} else {
			response.put("sample", sample);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map updateSample(String sampleCode, String category,
			String popularity, String year, String weight, String price,
			String view, String designFile, String gender, String styleID,
			String machineIDs, String yarns, String description) {

		ResponseMap response = new ResponseMap();

		String[] tokensMachineIDs = machineIDs.split(",");
		String[] tokensYarnIds = yarns.split(",");
		String[] tokensDescriptionattributes = description.split(" ");
		String[] sizeDescription = tokensDescriptionattributes[0].split(",");
		String   buttonStyle = tokensDescriptionattributes[1];
		String   buttonSize = tokensDescriptionattributes[2];
		String[] accessories = tokensDescriptionattributes[3].split(",");
		String[] color = tokensDescriptionattributes[4].split(",");

		Sample sample = sampleValidation.validateSampleAndGetSample(response,
				sampleCode, category, popularity, year, weight, price, view,
				designFile, gender, styleID, tokensMachineIDs, tokensYarnIds,
				sizeDescription,buttonStyle,buttonSize,accessories,color);

		Sample oldSample = sampleService.findBySampleCode(sampleCode);
	
		if (oldSample == null) {
			response.setError("Sample Does not exist ");
			return response;
		} else if (sample == null) {
			return response;
		} else {
			sample.setSampleId(oldSample.getSampleId());
			sampleService.update(sample);
			response.put("sample", sample);
		}

		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map searchSample(String sampleCode, String category,
		String startPopularity, String endPopularity,
		String equalPopularity, String startYear, String endYear,
		String equalYear, String startWeight, String endWeight,
		String equalWeight, String startPrice, String endPrice,
		String equalPrice,String gender, String styleID,
		String machineIDs, String yarns){
		
		ArrayList<Sample> sampleList = new ArrayList<Sample>();
	
        sampleList= searchService.searchSample(sampleCode,category,startPopularity,
		       		endPopularity,equalPopularity,startYear,endYear,equalYear,
		       		startWeight,endWeight,equalWeight,startPrice,endPrice,
		       		equalPrice,gender,styleID,machineIDs,yarns);
		
		ResponseMap response = new ResponseMap();

		if (sampleList.isEmpty()) {
			response.setError("No Sample found ");
			return response;

		} else {
			response.put("sampleList", sampleList);
			return response;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Map getAllSamples(){

		ResponseMap response = new ResponseMap();
		ArrayList<Sample> sampleList = new ArrayList<Sample>();
		sampleList =  searchService.searchSample("", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "");
		if (sampleList.isEmpty()) {
			response.setError("No Sample found ");
			return response;

		} else {
			response.put("sampleList", sampleList);
			return response;
		}
		
		
	}
	
}
