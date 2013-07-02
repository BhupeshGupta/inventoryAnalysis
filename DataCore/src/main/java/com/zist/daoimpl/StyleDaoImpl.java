package com.zist.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zist.dao.StyleDao;
import com.zist.frwkutil.CustomHibernateDaoSupport;
import com.zist.model.Style;

@Repository("styleDao")
public class StyleDaoImpl extends CustomHibernateDaoSupport implements StyleDao{
     
	public void save(Style style) {
		getHibernateTemplate().save(style);
		
	}

	public void update(Style style) {
		getHibernateTemplate().update(style);
		
	}

	public void delete(Style style) {
		getHibernateTemplate().delete(style);
		
	}

	public Style findByStyleCode(String StyleCode) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find("from Style where STYLE_CODE=?", StyleCode);
		if(list.size() > 0)
			return (Style)list.get(0);
		else
			return null;
	}

	public Style findByStyleId(String StyleId) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find("from Style where STYLE_ID=?", StyleId);
		if(list.size() > 0)
			return (Style)list.get(0);
		else
			return null;
	}

}
