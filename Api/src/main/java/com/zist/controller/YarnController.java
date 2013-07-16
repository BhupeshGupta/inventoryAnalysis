package com.zist.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.zist.model.Yarn;
import com.zist.service.SearchService;
import com.zist.service.YarnService;
import com.zist.utils.ResponseMap;
import com.zist.utils.yarnValidation;

@Controller
public class YarnController {

	@Autowired
	YarnService yarnService;
	@Autowired
	SearchService searchService;
	
	@SuppressWarnings("rawtypes")
	public Map getYarn(String yarnCode){
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
	public Map createYarn(String yarnCode,String yarnCount,String type,String price) {

		ResponseMap response = new ResponseMap();

		
		Yarn yarn = yarnValidation.validateYarnAndGetYarn(response, yarnCode, yarnCount,type,price);
		
		if (yarn == null)
			return response;
		
		try {
			yarnService.save(yarn);
		} catch (DataIntegrityViolationException e) {
			response.setError("Yarn already Exist ");
			return response;
		}
		
		response.put("yarn", yarn);
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	public Map deleteYarn(String yarnCode){
		
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
	public Map updateYarn(String yarnCode,String yarnCount,String type,String price){

		ResponseMap response = new ResponseMap();
		
		Yarn yarn = yarnValidation.validateYarnAndGetYarn(response, yarnCode, yarnCount,type,price);

		Yarn oldYarn = yarnService.findByYarnCode(yarnCode);
		
	    if(oldYarn == null){
	    	response.setError("Yarn Does not exist ");
	    } else if(yarn == null){
	    	return response;
	    }
	    else{
	    	yarn.setYarnId(oldYarn.getYarnId());
	    	yarnService.update(yarn);
	     	response.put("yarn", yarn);
	    }

	    return response;		
	}
	
	public ResponseMap searchYarn(String yarnCode, String startYarnCount,
			String endYarnCount, String equalYarnCount, String type,
			String startPrice, String endPrice, String equalPrice){

			ArrayList<Yarn> yarnList = new ArrayList<Yarn>();
	
			yarnList =  searchService.searchYarn(yarnCode,startYarnCount,endYarnCount,
					equalYarnCount,type,startPrice,endPrice,equalPrice);
		
			ResponseMap response = new ResponseMap();

			if (yarnList.isEmpty()) {
				response.setError("No Yarn found ");
				return response;

			} else {
				response.put("yarnList", yarnList);
				return response;
			}		
	}

	@SuppressWarnings("rawtypes")
	public Map getAllYarns(){

		ResponseMap response = new ResponseMap();
		ArrayList<Yarn> yarnList = new ArrayList<Yarn>();
		yarnList =  searchService.searchYarn("", "", "", "", "", "", "", "");
		if (yarnList.isEmpty()) {
			response.setError("No Yarn found ");
			return response;

		} else {
			response.put("yarnList", yarnList);
			return response;
		}
	}
}
