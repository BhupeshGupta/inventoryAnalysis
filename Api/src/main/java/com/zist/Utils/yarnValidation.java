package com.zist.Utils;

import com.zist.model.Yarn;
import com.zist.util.ResponseMap;

public class yarnValidation {

	public static Yarn validateYarnAndGetYarn(ResponseMap response, String yarnCode,
			Double yarnCount,String type,Double price){

		if(yarnCount<0){
			response.setError("Invalid input , Yarn count can not be negative");
			return null;
		}
		
		if(price<0){
			response.setError("Invalid input , Yarn price can not be negative");
			return null;
		}
		
		
		Yarn yarn = new Yarn();
		
		yarn.setYarnCode(yarnCode);
		yarn.setYarnCount(yarnCount);
		yarn.setYarnType(type);
		yarn.setYarnPrice(price);
		
		return yarn;
	}
}
