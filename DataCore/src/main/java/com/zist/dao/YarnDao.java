package com.zist.dao;

import org.hibernate.Session;

import com.zist.model.Yarn;

public interface YarnDao {

    void save(Yarn yarn);
    void update(Yarn yarn);
    void delete(Yarn yarn);
    Yarn findByYarnCode(String YarnCode);
    Yarn findByYarnId(String YarnId);
    Session retrieveSession();
}
