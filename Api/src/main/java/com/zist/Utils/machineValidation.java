package com.zist.Utils;

import com.zist.model.Machine;
import com.zist.util.ResponseMap;

public class machineValidation {

	public static Machine validateMachineAndGetMachine(ResponseMap response, 
			String machineCode, Double gauge){

		if(gauge < 0){
			response.setError("Invalid Input, Gauge cannot be negative");
			return null;
		}
		
		Machine machine = new Machine();
		
		machine.setMachineCode(machineCode);
		machine.setMachineGauge(gauge);
		
		return machine;
	}
}
