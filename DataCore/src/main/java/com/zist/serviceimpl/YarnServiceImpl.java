package com.zist.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zist.dao.YarnDao;
import com.zist.model.Yarn;


@Service("yarnService")
public class YarnServiceImpl {

	@Autowired
	YarnDao yarnDao;
	
	public void save(Yarn yarn) {
		yarnDao.save(yarn);
		
	    }

	    public void update(Yarn yarn) {
		yarnDao.update(yarn);
		
	    }

	    public void delete(Yarn yarn) {
		yarnDao.delete(yarn);
		
	    }

	    public Yarn findByYarnCode(String YarnCode) {
		return yarnDao.findByYarnCode(YarnCode);
	    }

	    public Yarn findByYarnId(String YarnId) {
		return yarnDao.findByYarnId(YarnId);
	    }
}
