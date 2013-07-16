package com.zist.dao;

import org.hibernate.Session;

import com.zist.model.Style;

public interface StyleDao {

    void save(Style style);
    void update(Style style);
    void delete(Style style);
    Style findByStyleCode(String StyleCode);
    Style findByStyleId(String StyleId);
    Session retrieveSession();
}
