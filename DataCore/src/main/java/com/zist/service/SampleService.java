package com.zist.service;

import com.zist.model.Sample;

public interface SampleService {
    
    void save(Sample sample);
    void update(Sample sample);
    void delete(Sample sample);
    Sample findBySampleCode(String SampleCode);
    Sample findBySampleId(String SampleId);
    // TODO: alter addMachine func.
    void addMachine();

}
