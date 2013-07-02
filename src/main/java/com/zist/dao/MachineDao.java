package com.zist.dao;

import com.zist.model.Machine;

public interface MachineDao {

    void save(Machine machine);
    void update(Machine machine);
    void delete(Machine machine);
    Machine findByMachineCode(String MachineCode);
    Machine findByMachineId(String MachineId);

}
