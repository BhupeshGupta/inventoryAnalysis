package com.zist.utils;

import com.zist.model.Machine;

public class machineValidation {

	public static Machine validateMachineAndGetMachine(ResponseMap response, 
			String machineCode, String gauge){

		Float validatedGauge;
		
		try{
			validatedGauge = Float.parseFloat(gauge);
			if(validatedGauge < 0){
				response.setError("Invalid Input, Gauge cannot be negative");
				return null;
			}
		} catch(NumberFormatException e){
			response.setError("Invalid Input, Please enter a numeric Gauge");
			return null;
		}
		
		Machine machine = new Machine();
		
		machine.setMachineCode(machineCode);
		machine.setMachineGauge(validatedGauge);
		
		return machine;
	}
}
