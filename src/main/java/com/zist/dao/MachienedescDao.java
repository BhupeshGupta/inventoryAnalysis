package com.zist.dao;

import com.zist.model.Machiene;

public interface MachienedescDao {

    void save(Machiene sample);
    void update(Machiene sample);
    void delete(Machiene sample);
    Machiene findByMachieneCode(String MachieneCode);
    Machiene findByMachieneId(String MachieneId);

}
