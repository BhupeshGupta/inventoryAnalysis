package com.zist.utils;

import com.zist.model.Yarn;

public class yarnValidation {

	public static Yarn validateYarnAndGetYarn(ResponseMap response, String yarnCode,
			String yarnCount,String type,String price){

		Float validatedYarnCount;
		Float validatedPrice;
		
		try{
			validatedYarnCount = Float.parseFloat(yarnCount);
			if(validatedYarnCount<0){
				response.setError("Invalid input , Yarn count can not be negative");
				return null;
			}
		} catch (NumberFormatException e){
			response.setError("Invalid input , Please enter a numeric Yarn count");
			return null;
			
		}
		try{
			validatedPrice = Float.parseFloat(price);
			if(validatedPrice<0){
				response.setError("Invalid input , Yarn price can not be negative");
				return null;
			}
		} catch (NumberFormatException e){
			response.setError("Invalid input , Please enter a numeric Yarn Price");
			return null;
			
		}
		
				
		Yarn yarn = new Yarn();
		
		yarn.setYarnCode(yarnCode);
		yarn.setYarnCount(validatedYarnCount);
		yarn.setYarnType(type);
		yarn.setYarnPrice(validatedPrice);
		
		return yarn;
	}
}
