package com.zist.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.zist.dao.YarnDao;
import com.zist.frwkutil.CustomHibernateDaoSupport;
import com.zist.model.Yarn;

@Repository("yarnDao")
public class YarnDaoImpl extends CustomHibernateDaoSupport implements YarnDao{


	public void save(Yarn yarn) {
		getHibernateTemplate().save(yarn);

		
	}

	public void update(Yarn yarn) {
		getHibernateTemplate().update(yarn);
		
	}

	public void delete(Yarn yarn) {
		getHibernateTemplate().delete(yarn);
		
	}

	public Yarn findByYarnCode(String YarnCode) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find("from Yarn where YARN_CODE=?", YarnCode);
		if(list.size() > 0)
			return (Yarn)list.get(0);
		else
			return null;
	}

	public Yarn findByYarnId(String YarnId) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find("from Yarn where Yarn_ID=?", YarnId);
		if(list.size() > 0)
			return (Yarn)list.get(0);
		else
			return null;
	}

	public Session retrieveSession() {
		return getSession();
	}
}
