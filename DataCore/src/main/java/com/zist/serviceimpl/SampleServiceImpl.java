package com.zist.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.NotImplemented;
import com.zist.dao.SampleDao;
import com.zist.model.Sample;
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

	public void addMachine() {
		// TODO : complete  this and similer Func. 
		throw new UnsupportedOperationException("Implement This Function");
		
	}

}
