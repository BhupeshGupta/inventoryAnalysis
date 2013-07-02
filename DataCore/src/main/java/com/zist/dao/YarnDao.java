package com.zist.dao;

import com.zist.model.Yarn;

public interface YarnDao {

    void save(Yarn yarn);
    void update(Yarn yarn);
    void delete(Yarn yarn);
    Yarn findByYarnCode(String YarnCode);
    Yarn findByYarnId(String YarnId);

}
