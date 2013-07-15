package com.zist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.zist.model.Sample;
import com.zist.service.SampleService;
import com.zist.utils.ResponseMap;
import com.zist.utils.sampleValidation;

@Controller
public class SampleController {

	@Autowired
	SampleService sampleService;

	@SuppressWarnings("rawtypes")
	public Map getSample(String sampleCode) {
		ResponseMap response = new ResponseMap();
		Sample sample = sampleService.findBySampleCode(sampleCode);
		if (sample == null) {
			response.setStatus("1");
			response.setMessage("Sample Does not exist ");
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
			response.setStatus("1");
			response.setMessage("Sample Does not exist ");
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

}
