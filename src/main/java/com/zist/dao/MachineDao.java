package com.zist.dao;

import com.zist.model.Machine;

public interface MachineDao {

    void save(Machine sample);
    void update(Machine sample);
    void delete(Machine sample);
    Machine findByMachineCode(String MachineCode);
    Machine findByMachineId(String MachineId);

}
