package com.zist.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zist.dao.MachineDao;
import com.zist.frwkutil.CustomHibernateDaoSupport;
import com.zist.model.Machine;

@Repository("machineDao")
public class MachineDaoImpl extends CustomHibernateDaoSupport implements MachineDao{


	public void save(Machine machine) {
		getHibernateTemplate().save(machine);
		
	}

	public void update(Machine machine) {
		getHibernateTemplate().update(machine);
		
	}

	public void delete(Machine machine) {
		getHibernateTemplate().delete(machine);
		
	}

	public Machine findByMachineCode(String MachineCode) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find("from Machine where MACHINE_CODE=?", MachineCode);
		if(list.size() > 0)
			return (Machine)list.get(0);
		else
			return null;
	}

	public Machine findByMachineId(String MachineId) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find("from Machine where MACHINE_ID=?", MachineId);
		if(list.size() > 0)
			return (Machine)list.get(0);
		else
			return null;
	}

}
