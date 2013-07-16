package com.zist.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zist.dao.MachineDao;
import com.zist.dao.SampleDao;
import com.zist.dao.StyleDao;
import com.zist.dao.YarnDao;
import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;
import com.zist.service.SearchService;

@Service("searchService")
public class SearchServiceImpl implements SearchService{

	@Autowired
	SampleDao sampleDao;

	@Autowired
	MachineDao machineDao;

	@Autowired
	StyleDao styleDao;
	
	@Autowired
	YarnDao yarnDao;
	Float point=(float) 0.00001;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Sample> searchSample(String sampleCode, String category,
			String startPopularity, String endPopularity, String equalPopularity,
			String startYear,String endYear, String equalYear,
			String startWeight, String endWeight,String equalWeight,
			String startPrice, String endPrice,String equalPrice, 
			String gender, String styleID,String machineIDs, String yarns) {
			Float temp;
		Session session = sampleDao.retrieveSession();
		
		Criteria criteria = session.createCriteria(Sample.class);

		if(!sampleCode.isEmpty()){
				criteria.add(Restrictions.eq("sampleCode",sampleCode));
		}

		if(!category.isEmpty()){
				criteria.add(Restrictions.eq("category",category));
		}
	
		if(!startPopularity.isEmpty()){
				temp = Float.parseFloat(startPopularity);
				criteria.add(Restrictions.ge("popularity",new Float(temp-point)));
		}

		if(!endPopularity.isEmpty()){
				temp = Float.parseFloat(endPopularity);
				criteria.add(Restrictions.le("popularity",new Float(temp + point)));
		}
		
		if(!equalPopularity.isEmpty()){
			
			criteria.add(Restrictions.between("popularity",new Float(Float.parseFloat(equalPopularity)-point)
					,new Float(Float.parseFloat(equalPopularity)+point)));
			
		}

		if(!startYear.isEmpty()){
			
				criteria.add(Restrictions.ge("year",new Float(Float.parseFloat(startYear)-0.1)));
		}

		if(!endYear.isEmpty()){
			
				criteria.add(Restrictions.le("year",new Float(Float.parseFloat(endYear)+0.1)));
		}

		if(!equalYear.isEmpty()){

			criteria.add(Restrictions.between("year",new Float(Float.parseFloat(equalYear)-0.1)
					,new Float(Float.parseFloat(equalYear)+0.1)));
			
		}

		if(!startWeight.isEmpty()){
			
			criteria.add(Restrictions.ge("weight",new Float(Float.parseFloat(startWeight)-point)));
		}

		if(!endWeight.isEmpty()){
		
			criteria.add(Restrictions.le("weight",new Float(Float.parseFloat(endWeight)+point)));
		}
		
		if(!equalWeight.isEmpty()){

			criteria.add(Restrictions.between("weight",new Float(Float.parseFloat(endWeight)-point),
					new Float(Float.parseFloat(endWeight)+point)));
			
		}


		if(!startPrice.isEmpty()){
		
			criteria.add(Restrictions.ge("price",new Float(Float.parseFloat(startPrice)-point)));
		}

		if(!endPrice.isEmpty()){
		
			criteria.add(Restrictions.le("price",new Float(Float.parseFloat(endPrice)+point)));
		}
		
		if(!equalPrice.isEmpty()){

			criteria.add(Restrictions.between("price",new Float(Float.parseFloat(equalPrice)-point)
					,new Float(Float.parseFloat(endPrice)+point)));
			
		}

		if(!gender.isEmpty()){
			if(gender.toUpperCase() == "M" || gender.toUpperCase() == "MALE") gender = "MALE";
			if(gender.toUpperCase() == "F" || gender.toUpperCase() == "FEMALE") gender = "FEMALE";			
			criteria.add(Restrictions.eq("gender",gender));
		}

		if(!styleID.isEmpty()){
		
			criteria.createAlias("style", "s");
			criteria.add(Restrictions.eq("s.styleCode", styleID));
		}
		
		if(!machineIDs.isEmpty()){
			String[] machines = machineIDs.split(",");
			criteria.createAlias("machines", "ma");
//			if(machines.length>1)
				for(int i=0;i<machines.length;i++){
					criteria.add(Restrictions.eq("ma.machineCode", machines[i]));
			}
		}
		
		if(!yarns.isEmpty()){
			String[] yarn = yarns.split(",");
			criteria.createAlias("yarn", "ya");
			for(int i =0;i<yarn.length;i++){
				criteria.add(Restrictions.eq("ya.yarnCode", yarn[i]));
			}
		}
		return (ArrayList<Sample>) uniqueList(criteria);
		}

	@SuppressWarnings("unchecked")
	public ArrayList<Machine> searchMachine(String machineCode,String startGauge,
			String endGauge,String equalGauge) {
		
		Session session = machineDao.retrieveSession();
		Float gauge ;

		Criteria criteria = session.createCriteria(Machine.class);
		if(!machineCode.isEmpty()){
				criteria.add(Restrictions.eq("machineCode",machineCode));
		}
		
		if(!startGauge.isEmpty()){
			gauge = Float.parseFloat(startGauge);
			criteria.add(Restrictions.ge("machineGauge", (float)(gauge-point)));
		}

		if(!endGauge.isEmpty()){
			gauge = Float.parseFloat(endGauge);	
			criteria.add(Restrictions.le("machineGauge",(float)(gauge+point)));
			
		}
		
		if(!equalGauge.isEmpty()){
			gauge = Float.parseFloat(equalGauge);
			criteria.add(Restrictions.between("machineGauge",(float)(gauge-point),(float)(gauge+point)));
		}
		return (ArrayList<Machine>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Yarn> searchYarn(String yarnCode,String startYarnCount,String endYarnCount,
			String equalYarnCount, String yarnType,String startPrice,String endPrice,String equalPrice) {

		Session session = yarnDao.retrieveSession();

		Criteria criteria = session.createCriteria(Yarn.class);

		float count;
		
		if(!yarnCode.isEmpty()){
			criteria.add(Restrictions.eq("yarnCode",yarnCode));
		}
	
		if(!startYarnCount.isEmpty()){
		count = Float.parseFloat(startYarnCount);
		criteria.add(Restrictions.ge("yarnCount",new Float(count-point)));
		}

		if(!endYarnCount.isEmpty()){
		count = Float.parseFloat(endYarnCount);
		criteria.add(Restrictions.le("yarnCount",new Float(count+point)));
		}
	
		if(!equalYarnCount.isEmpty()){
		count = Float.parseFloat(equalYarnCount);
		System.out.println("\n"+count+"\n");
		criteria.add(Restrictions.between("yarnCount",new Float(count-point),new Float(count+point)));
		}
		
		if(!startPrice.isEmpty()){
			count = Float.parseFloat(startPrice);	
			criteria.add(Restrictions.ge("price",(float)(count-point)));
		}
		
		if(!endPrice.isEmpty()){
			count = Float.parseFloat(endPrice);
			criteria.add(Restrictions.le("price",(float)(count+point)));
		}
		
		if(!equalPrice.isEmpty()){
			count = Float.parseFloat(equalPrice);
			criteria.add(Restrictions.between("price",(float)(count-point),(float)(count+point)));
			
		}
		
		if(!yarnType.isEmpty()){
			criteria.add(Restrictions.eq("yarnType",yarnType));
		}

		return (ArrayList<Yarn>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Style> searchStyle(String styleCode, String knitPattern) {

		Session session = sampleDao.retrieveSession();

		Criteria criteria = session.createCriteria(Style.class);

		if(!styleCode.isEmpty()){
			criteria.add(Restrictions.eq("styleCode",styleCode));
		}

		if(!knitPattern.isEmpty()){
			criteria.add(Restrictions.eq("knitPattern",knitPattern));
		}
		return (ArrayList<Style>) criteria.list();
	}



	 public List<?> uniqueList(Criteria criteria) {
	        List<?> list = criteria.list();
	        Set<Integer> idSet = new HashSet<Integer>(list.size());
	        for (Iterator<?> iter = list.iterator(); iter.hasNext();) {
	            Sample sample = (Sample) iter.next();
	            Integer id = sample.getSampleId();
	            if (idSet.contains(id)) {
	                iter.remove();
	            } else {
	                idSet.add(id);
	            }
	        }
	        return list;
	    }
}
