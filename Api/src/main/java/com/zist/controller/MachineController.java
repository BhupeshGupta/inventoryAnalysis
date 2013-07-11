package com.zist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zist.Utils.machineValidation;
import com.zist.model.Machine;
import com.zist.service.MachineService;
import com.zist.util.ResponseMap;

public class MachineController {

	@Autowired
	MachineService machineService;
	
	@SuppressWarnings("rawtypes")
	Map getMachine(String machineCode){

		ResponseMap response = new ResponseMap();
		Machine machine = machineService.findByMachineCode(machineCode);

		if(machine == null){
	    	response.setError("Machine Does not exist ");
	    }
		else{
			response.put("machine", machine);
		}
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	Map createMachine(String machineCode,Double gauge) {

		ResponseMap response = new ResponseMap();

		
		Machine machine = machineValidation.validateMachineAndGetMachine(response, machineCode, gauge);
		
		if (machine == null)
			return response;
		
		machineService.save(machine);
		
		response.put("machine", machine);
		return response;
	}

	@SuppressWarnings("rawtypes")
	Map deleteMachine(String machineCode){
		ResponseMap response = new ResponseMap();

		Machine machine = machineService.findByMachineCode(machineCode);

		if(machine == null){
	    	response.setError("Machine Does not exist ");
	    }
	    else{
	    	response.put("machine", machine);
	    }
	    return response;
	}
	
	@SuppressWarnings("rawtypes")
	Map updateMachine(String machineCode,Double gauge){

		ResponseMap response = new ResponseMap();
		
		Machine machine = machineValidation.validateMachineAndGetMachine(response, machineCode, gauge);

		Machine oldMachine = machineService.findByMachineCode(machineCode);
	    if(oldMachine == null){
	    	response.setError("Machine Does not exist ");
	    }
	    else{
	    	machine.setMachineId(oldMachine.getMachineId());
	    	machineService.update(machine);
	     	response.put("machine", machine);
	    }

	    return response;		
	}
	
}
