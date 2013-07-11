package com.zist.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zist.dao.StyleDao;
import com.zist.model.Style;
import com.zist.service.StyleService;


@Service("styleService")
public class StyleServiceImpl implements StyleService{

	@Autowired
	StyleDao styleDao;
	
	public void save(Style style) {
		styleDao.save(style);
		
	    }

	    public void update(Style style) {
		styleDao.update(style);
		
	    }

	    public void delete(Style style) {
		styleDao.delete(style);
		
	    }

	    public Style findByStyleCode(String StyleCode) {
		return styleDao.findByStyleCode(StyleCode);
	    }

	    public Style findByStyleID(String StyleId) {
		return styleDao.findByStyleId(StyleId);
	    }

}
