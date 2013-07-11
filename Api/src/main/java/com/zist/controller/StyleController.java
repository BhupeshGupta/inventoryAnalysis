package com.zist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zist.Utils.styleValidation;
import com.zist.model.Style;
import com.zist.service.StyleService;
import com.zist.util.ResponseMap;

public class StyleController {

	@Autowired
	StyleService styleService;
	
	@SuppressWarnings("rawtypes")
	Map getStyle(String styleCode){

		ResponseMap response = new ResponseMap();
		Style style = styleService.findByStyleCode(styleCode);
		if(style == null){
	    	response.setError("Style Does not exist ");
	    }
		else{
			response.put("style", style);
		}
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	Map createStyle(String styleCode,String knitPattern) {

		ResponseMap response = new ResponseMap();

		
		Style style = styleValidation.validateStyleAndGetStyle(response, styleCode, knitPattern);
		
		if (style == null)
			return response;
		
		styleService.save(style);
		
		response.put("style", style);
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	Map deleteStyle(String styleCode){
		ResponseMap response = new ResponseMap();

		Style style = styleService.findByStyleCode(styleCode);

		if(style == null){
	    	response.setError("Style Does not exist ");
	    }
	    else{
	    	response.put("style", style);
	    }
	    return response;
	}
	@SuppressWarnings("rawtypes")
	Map updateStyle(String styleCode,String knitPattern){

		ResponseMap response = new ResponseMap();
		
		Style style = styleValidation.validateStyleAndGetStyle(response, styleCode, knitPattern);

		Style oldStyle = styleService.findByStyleCode(styleCode);

		if(oldStyle == null){
	    	response.setError("Style Does not exist ");
	    }
	    else{
	    	style.setStyleId(oldStyle.getStyleId());
	    	styleService.update(style);
	     	response.put("style", style);
	    }

	    return response;		
	}
	
}
