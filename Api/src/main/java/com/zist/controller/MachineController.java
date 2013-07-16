package com.zist.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.zist.model.Machine;
import com.zist.service.MachineService;
import com.zist.service.SearchService;
import com.zist.utils.ResponseMap;
import com.zist.utils.machineValidation;

@Controller
public class MachineController {

	@Autowired
	MachineService machineService;
	
	@Autowired
	SearchService searchService;

	@SuppressWarnings("rawtypes")
	public Map getAllMachines(){

		ResponseMap response = new ResponseMap();
		ArrayList<Machine> machineList = new ArrayList<Machine>();
		machineList =  searchService.searchMachine("","","","");
		if (machineList.isEmpty()) {
			response.setError("No Machine found ");
			return response;

		} else {
			response.put("machineList", machineList);
			return response;
		}
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public Map getMachine(String machineCode) {

		ResponseMap response = new ResponseMap();
		Machine machine = machineService.findByMachineCode(machineCode);

		if (machine == null) {
			response.setError("Machine Does not exist ");
		} else {
			response.put("machine", machine);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map createMachine(String machineCode, String gauge) {

		ResponseMap response = new ResponseMap();

		Machine machine = machineValidation.validateMachineAndGetMachine(
				response, machineCode, gauge);

		if (machine == null)
			return response;

		try {
			machineService.save(machine);
		} catch (DataIntegrityViolationException e) {
			response.setError("Machine already Exist ");
			return response;
		}

		response.put("machine", machine);
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map deleteMachine(String machineCode) {
		ResponseMap response = new ResponseMap();

		Machine machine = machineService.findByMachineCode(machineCode);

		if (machine == null) {
			response.setError("Machine Does not exist ");
		} else {
			response.put("machine", machine);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	public Map updateMachine(String machineCode, String gauge) {

		ResponseMap response = new ResponseMap();

		Machine machine = machineValidation.validateMachineAndGetMachine(
				response, machineCode, gauge);

		Machine oldMachine = machineService.findByMachineCode(machineCode);
		if (oldMachine == null) {
			response.setError("Machine Does not exist ");
		} else if (machine == null) {
			return response;
		} else {
			machine.setMachineId(oldMachine.getMachineId());
			machineService.update(machine);
			response.put("machine", machine);
		}

		return response;
	}
	
	public ResponseMap searchMachine(String machineCode, String startGauge,
			String endGauge, String equalGauge){

			ArrayList<Machine> machineList = new ArrayList<Machine>();
	
			machineList =  searchService.searchMachine(machineCode,startGauge,endGauge,equalGauge);
		
			ResponseMap response = new ResponseMap();

			if (machineList.isEmpty()) {
				response.setError("No Machine found ");
				return response;

			} else {
				response.put("machineList", machineList);
				return response;
			}
		
	}

}
