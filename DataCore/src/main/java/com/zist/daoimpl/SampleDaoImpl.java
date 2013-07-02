package com.zist.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zist.dao.SampleDao;
import com.zist.frwkutil.CustomHibernateDaoSupport;
import com.zist.model.Sample;

@Repository("sampleDao")
public class SampleDaoImpl extends CustomHibernateDaoSupport implements SampleDao{

    public void save(Sample sample) {
	getHibernateTemplate().save(sample);
	
    }

    public void update(Sample sample) {
	getHibernateTemplate().update(sample);
	
    }

    public void delete(Sample sample) {
	getHibernateTemplate().delete(sample);
	
    }

    public Sample findBySampleCode(String SampleCode) {
	@SuppressWarnings("rawtypes")
	List list = getHibernateTemplate().find("from Sample where SAMPLE_CODE=?", SampleCode);
	if(list.size() > 0)
		return (Sample)list.get(0);
	else
		return null;
    }

    public Sample findBySampleId(String SampleId) {
	@SuppressWarnings("rawtypes")
	List list = getHibernateTemplate().find("from Sample where SAMPLE_ID=?", SampleId);
	if(list.size() > 0)
		return (Sample)list.get(0);
	else
		return null;
    }

}
