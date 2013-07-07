package com.zist.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zist.dao.DescriptionDao;
import com.zist.model.Description;


@Service("descriptionService")
public class DescriptionServiceImpl {

	@Autowired
	DescriptionDao descriptionDao;
	
	public void save(Description description) {
		descriptionDao.save(description);
		
	    }

	    public void update(Description description) {
		descriptionDao.update(description);
		
	    }

	    public void delete(Description description) {
		descriptionDao.delete(description);
		
	    }

	    public Description findByDescriptionId(String DescriptionId) {
		return descriptionDao.findByDescriptionId(DescriptionId);
	    }
}
