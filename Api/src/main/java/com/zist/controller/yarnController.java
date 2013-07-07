package com.zist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zist.Utils.yarnValidation;
import com.zist.model.Yarn;
import com.zist.service.YarnService;
import com.zist.util.ResponseMap;

public class yarnController {

	@Autowired
	YarnService yarnService;
	
	@SuppressWarnings("rawtypes")
	Map getYarn(String yarnCode){
		ResponseMap response = new ResponseMap();
		Yarn yarn = yarnService.findByYarnCode(yarnCode);

		if(yarn == null){
	    	response.setError("Yarn Does not exist ");
	    }
		else{
			response.put("yarn", yarn);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	Map createYarn(String yarnCode,Double yarnCount,String type,Double price) {

		ResponseMap response = new ResponseMap();

		
		Yarn yarn = yarnValidation.validateYarnAndGetYarn(response, yarnCode, yarnCount,type,price);
		
		if (yarn == null)
			return response;
		
		yarnService.save(yarn);
		
		response.put("yarn", yarn);
		return response;
	}
	
	Map deleteYarn(String yarnCode){
		
		ResponseMap response = new ResponseMap();

		Yarn yarn = yarnService.findByYarnCode(yarnCode);

		if(yarn == null){
	    	response.setError("Yarn Does not exist ");
	    }
	    else{
	    	response.put("yarn", yarn);
	    }
	    return response;
	}
	
	Map updateYarn(String yarnCode,Double yarnCount,String type,Double price){

		ResponseMap response = new ResponseMap();
		
		Yarn yarn = yarnValidation.validateYarnAndGetYarn(response, yarnCode, yarnCount,type,price);

		Yarn oldYarn = yarnService.findByYarnCode(yarnCode);
		
	    if(oldYarn == null){
	    	response.setError("Yarn Does not exist ");
	    }
	    else{
	    	yarn.setYarnId(oldYarn.getYarnId());
	    	yarnService.update(yarn);
	     	response.put("yarn", yarn);
	    }

	    return response;		
	}
	
}
