package com.zist.dao;

import com.zist.model.Sample;

public interface SampleDao {
    
    void save(Sample sample);
    void update(Sample sample);
    void delete(Sample sample);
    Sample findBySampleCode(String SampleCode);
    Sample findBySampleId(String SampleId);
    
}
