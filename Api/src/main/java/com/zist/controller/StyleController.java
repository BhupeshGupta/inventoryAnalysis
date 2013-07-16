package com.zist.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.zist.model.Style;
import com.zist.service.SearchService;
import com.zist.service.StyleService;
import com.zist.utils.ResponseMap;
import com.zist.utils.styleValidation;

@Controller
public class StyleController {

	@Autowired
	StyleService styleService;
	
	@Autowired
	SearchService searchService;

	@SuppressWarnings("rawtypes")
	public Map getStyle(String styleCode) {

		ResponseMap response = new ResponseMap();
		Style style = styleService.findByStyleCode(styleCode);
		if (style == null) {
			response.setError("Style Does not exist ");
		} else {
			response.put("style", style);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map createStyle(String styleCode, String knitPattern) {

		ResponseMap response = new ResponseMap();

		Style style = styleValidation.validateStyleAndGetStyle(response,
				styleCode, knitPattern);

		if (style == null)
			return response;

		try {
			styleService.save(style);
		} catch (DataIntegrityViolationException e) {
			response.setError("Style already Exist ");
			return response;
		}

		response.put("style", style);
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map deleteStyle(String styleCode) {
		ResponseMap response = new ResponseMap();

		Style style = styleService.findByStyleCode(styleCode);

		if (style == null) {
			response.setError("Style Does not exist ");
		} else {
			response.put("style", style);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map updateStyle(String styleCode, String knitPattern) {

		ResponseMap response = new ResponseMap();

		Style style = styleValidation.validateStyleAndGetStyle(response,
				styleCode, knitPattern);

		Style oldStyle = styleService.findByStyleCode(styleCode);

		if (oldStyle == null) {
			response.setError("Style Does not exist ");
			return response;
		} else if (style == null) {
			return response;
		} else {
			style.setStyleId(oldStyle.getStyleId());
			styleService.update(style);
			response.put("style", style);
		}

		return response;
	}

	public ResponseMap searchStyle(String styleCode, String knitPattern){

			ArrayList<Style> styleList = new ArrayList<Style>();
	
			styleList =  searchService.searchStyle(styleCode, knitPattern);
		
			ResponseMap response = new ResponseMap();

			if (styleList.isEmpty()) {
				response.setError("No Style found ");
				return response;

			} else {
				response.put("styleList", styleList);
				return response;
			}
		
	}

	@SuppressWarnings("rawtypes")
	public Map getAllStyles(){

		ResponseMap response = new ResponseMap();
		ArrayList<Style> styleList = new ArrayList<Style>();
		styleList =  searchService.searchStyle("", "");
		if (styleList.isEmpty()) {
			response.setError("No Style found ");
			return response;

		} else {
			response.put("styleList", styleList);
			return response;
		}
	}
}
