package com.zist.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zist.dao.DescriptionDao;
import com.zist.frwkutil.CustomHibernateDaoSupport;
import com.zist.model.Description;

@Repository("descriptionDao")
public class DescriptionDaoImpl extends CustomHibernateDaoSupport implements DescriptionDao{

	public void save(Description description) {
		getHibernateTemplate().save(description);
		
	}

    public void update(Description description) {
	getHibernateTemplate().update(description);
	
    }

    public void delete(Description description) {
	getHibernateTemplate().delete(description);
	
    }

    public Description findByDescriptionId(String DescriptionId) {
	@SuppressWarnings("rawtypes")
	List list = getHibernateTemplate().find("from Description where DESCRIPTION_ID=?", DescriptionId);
	if(list.size() > 0)
		return (Description)list.get(0);
	else
		return null;
    }



}
