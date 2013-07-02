package com.zist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zist.Utils.sampleValidation;
import com.zist.model.Sample;
import com.zist.service.SampleService;
import com.zist.util.ResponseMap;

public class sampleController {
	@Autowired
	SampleService sampleService;

	@SuppressWarnings("rawtypes")
	Map getSample(String sampleCode) {
		ResponseMap response = new ResponseMap();
		Sample sample = sampleService.findBySampleCode(sampleCode);
		response.put("sample", sample);
		return response;
	}

	@SuppressWarnings("rawtypes")
	Map createSample(String gender) {
		ResponseMap response = new ResponseMap();

		Sample sample = sampleValidation.validateSampleAndGetSample(response,
				gender);
		if (sample == null)
			return response;
		
		sampleService.save(sample);
		
		response.put("sample", sample);
		return response;
	}

}
