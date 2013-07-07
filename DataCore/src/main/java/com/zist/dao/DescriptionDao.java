package com.zist.dao;

import com.zist.model.Description;

public interface DescriptionDao {

    void save(Description description);
    void update(Description description);
    void delete(Description description);
    Description findByDescriptionId(String DescriptionId);

}
