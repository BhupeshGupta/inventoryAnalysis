package com.zist.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.zist.Utils.sampleValidation;
import com.zist.model.Description;
import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;
import com.zist.service.SampleService;
import com.zist.util.ResponseMap;

public class sampleController {
	@Autowired
	SampleService sampleService;

	@SuppressWarnings("rawtypes")
	Map getSample(String sampleCode) {
		ResponseMap response = new ResponseMap();
		Sample sample = sampleService.findBySampleCode(sampleCode);
		if(sample == null){
	    	response.setStatus("1");
	    	response.setMessage("Sample Does not exist ");
	    }
		else{
			response.put("sample", sample);
		}
		return response;
	}
		
	@SuppressWarnings("rawtypes")
	Map createSample(String sampleCode,String category, Float popularity,String year,Float weight,
			Float price,String view,String designFile,String gender,String styleID,String machineIDs,
			String yarns,String descriptionID) {

		ResponseMap response = new ResponseMap();

		String[] tokensMachineIDs = machineIDs.split(","); 
		String[] tokensYarnIds = yarns.split(",");
		
		Sample sample = sampleValidation.validateSampleAndGetSample(response,
				sampleCode,category,popularity,year,weight,price,view,designFile,
				gender,styleID,tokensMachineIDs,tokensYarnIds,descriptionID);
		
		if (sample == null)
			return response;
		
		sampleService.save(sample);
		
		response.put("sample", sample);
		return response;
	}
	
	Map deleteSample(String sampleCode){
		ResponseMap response = new ResponseMap();

		Sample sample = sampleService.findBySampleCode(sampleCode);
	    if(sample == null){
	    	response.setStatus("1");
	    	response.setMessage("Sample Does not exist ");
	    }
	    else{
	    	response.put("sample", sample);
	    }
	    return response;
	}
	
	Map updateSample(String sampleCode,String category, Float popularity,String year,Float weight,
			Float price,String view,String designFile,String gender,String styleID,String machineIDs,
			String yarns,String descriptionID){

		ResponseMap response = new ResponseMap();
		
		String[] tokensMachineIDs = machineIDs.split(","); 
		String[] tokensYarnIds = yarns.split(",");
		
		Sample sample = sampleValidation.validateSampleAndGetSample(response,
				sampleCode,category,popularity,year,weight,price,view,designFile,
				gender,styleID,tokensMachineIDs,tokensYarnIds,descriptionID);

		Sample oldSample = sampleService.findBySampleCode(sampleCode);
	    if(oldSample == null){
	    	response.setStatus("1");
	    	response.setMessage("Sample Does not exist ");
	    }
	    else{
	    	sample.setSampleId(oldSample.getSampleId());
	    	sampleService.update(sample);
	     	response.put("sample", sample);
	    }

	    return response;		
	}
	
}
