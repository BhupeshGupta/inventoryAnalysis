package com.zist.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zist.dao.SampleDao;
import com.zist.model.Description;
import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;
import com.zist.service.SampleService;

@Service("sampelService")
public class SampleServiceImpl implements SampleService {
    
    @Autowired
    SampleDao sampleDao;

    public void save(Sample sample) {
	sampleDao.save(sample);
	
    }

    public void update(Sample sample) {
	sampleDao.update(sample);
	
    }

    public void delete(Sample sample) {
	sampleDao.delete(sample);
	
    }

    public Sample findBySampleCode(String SampleCode) {
	return sampleDao.findBySampleCode(SampleCode);
    }

    public Sample findBySampleId(String SampleId) {
	return sampleDao.findBySampleId(SampleId);
    }


	public void addSetOfMachines(Sample sample, Set<Machine> machines) {
		sample.setMachines(machines);
		sampleDao.save(sample);
	}

	public void updateSetOfMachines(Sample sample, Set<Machine> machines) {
		sample.setMachines(machines);
		sampleDao.update(sample);
		
	}

	public void addStyle(Sample sample, Style style) {
		sample.setStyle(style);
		sampleDao.save(sample);
	}

	public void updateStyle(Sample sample, Style style) {
		sample.setStyle(style);
		sampleDao.update(sample);
		
	}

	public void addSetOfYarns(Sample sample, Set<Yarn> yarns) {
		sample.setYarn(yarns);
		sampleDao.save(sample);
	}

	public void updateSetOfYarns(Sample sample, Set<Yarn> yarns) {
		sample.setYarn(yarns);
		sampleDao.update(sample);
		
	}

	public void addDescription(Sample sample, Description decription) {
		sample.setDescription(decription);
		sampleDao.save(sample);
	}

	public void updateDescritpion(Sample sample, Description description) {
		sample.setDescription(description);
		sampleDao.update(sample);
		
	}

}
