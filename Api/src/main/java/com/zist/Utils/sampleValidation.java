package com.zist.Utils;

import com.zist.model.Sample;
import com.zist.util.ResponseMap;

public class sampleValidation {
	public static Sample validateSampleAndGetSample(ResponseMap response, String gender) {
		// TODO: Get parameters, validate and plug it in sample entity

		gender = gender.toUpperCase();
		if (gender == "MALE" || gender == "M") {
			gender = "MALE";
		} else if (gender == "FEMALE" || gender == "F") {
			gender = "FEMALE";
		} else {
			response.setStatus("0");
			response.setMessage("Invalid Gender. Choose M/F");
			return null;
		}
		
		Sample sample = new Sample();
		sample.setGender(gender);
		return sample;
	}

}
