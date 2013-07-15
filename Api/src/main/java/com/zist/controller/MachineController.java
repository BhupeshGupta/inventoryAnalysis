package com.zist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.zist.model.Machine;
import com.zist.service.MachineService;
import com.zist.utils.ResponseMap;
import com.zist.utils.machineValidation;

@Controller
public class MachineController {

	@Autowired
	MachineService machineService;

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

}
