package com.zist.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zist.dao.SampleDao;
import com.zist.model.Sample;
import com.zist.util.CustomHibernateDaoSupport;

@Repository("sampleDao")
public class SampleDaoImpl extends CustomHibernateDaoSupport implements SampleDao{

    @Override
    public void save(Sample sample) {
	getHibernateTemplate().save(sample);
	
    }

    @Override
    public void update(Sample sample) {
	getHibernateTemplate().update(sample);
	
    }

    @Override
    public void delete(Sample sample) {
	getHibernateTemplate().delete(sample);
	
    }

    @Override
    public Sample findBySampleCode(String SampleCode) {
	@SuppressWarnings("rawtypes")
	List list = getHibernateTemplate().find("from Sample where SAMPLE_CODE=?", SampleCode);
	if(list.size() > 0)
		return (Sample)list.get(0);
	else
		return null;
    }

    @Override
    public Sample findBySampleId(String SampleId) {
	@SuppressWarnings("rawtypes")
	List list = getHibernateTemplate().find("from Sample where SAMPLE_ID=?", SampleId);
	if(list.size() > 0)
		return (Sample)list.get(0);
	else
		return null;
    }

}
