package com.zist.dao;

import com.zist.model.Description;

public interface DescriptionDao {

    void save(Description description);
    void update(Description description);
    void delete(Description description);
    Description findByDescriptionCode(String DescriptionCode);
    Description findByDescriptionId(String DescriptionId);

}
