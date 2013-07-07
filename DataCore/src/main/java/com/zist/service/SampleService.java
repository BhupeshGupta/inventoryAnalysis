package com.zist.service;

import java.util.Set;

import com.zist.model.Description;
import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;

public interface SampleService {
    
    void save(Sample sample);
    void update(Sample sample);
    void delete(Sample sample);

    Sample findBySampleCode(String SampleCode);
    Sample findBySampleId(String SampleId);
    // TODO: alter addMachine func.
 
    void addSetOfMachines(Sample sample,Set<Machine> machines);
    void updateSetOfMachines(Sample sample,Set<Machine> machines);
    
    void addStyle(Sample sample,Style style);
    void updateStyle(Sample sample,Style style);
 
    void addSetOfYarns(Sample sample,Set<Yarn> yarns);
    void updateSetOfYarns(Sample sample,Set<Yarn> yarns);

    void addDescription(Sample sample,Description decription);
    void updateDescritpion(Sample sample,Description description);
    
}
