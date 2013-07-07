package com.zist.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zist.dao.MachineDao;
import com.zist.model.Machine;

@Service("machineService")
public class MachineServiceImpl {

	@Autowired
	MachineDao machineDao;
	
	public void save(Machine machine) {
		machineDao.save(machine);
		
	    }

	    public void update(Machine machine) {
		machineDao.update(machine);
		
	    }

	    public void delete(Machine machine) {
		machineDao.delete(machine);
		
	    }

	    public Machine findByMachineCode(String MachineCode) {
		return machineDao.findByMachineCode(MachineCode);
	    }

	    public Machine findByMachineId(String MachineId) {
		return machineDao.findByMachineId(MachineId);
	    }
}
