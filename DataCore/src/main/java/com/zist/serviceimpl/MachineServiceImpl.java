package com.zist.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zist.dao.MachineDao;
import com.zist.model.Machine;
import com.zist.service.MachineService;

@Service("machineService")
public class MachineServiceImpl  implements MachineService{

	@Autowired
	MachineDao machineDao;
	
	public void save(Machine machine) {
		System.out.println(machine.getMachineCode() + "   " + machine.getMachineGauge());
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

	    public Machine findByMachineID(String MachineId) {
		return machineDao.findByMachineId(MachineId);
	    }
}
