package com.zist.service;

import com.zist.model.Machine;

public interface MachineService {

	public void save(Machine machine);
	public void update(Machine machine);
	public void delete(Machine machine);
	
	Machine findByMachineCode(String machineCode);
	Machine findByMachineID(String machineID);

}
