package com.zist.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;

public interface SearchService {

	ArrayList<Sample> searchSample(String sampleCode, String category,
			String startPopularity, String endPopularity,
			String equalPopularity, String startYear, String endYear,
			String equalYear, String startWeight, String endWeight,
			String equalWeight, String startPrice, String endPrice,
			String equalPrice, String gender, String styleID,
			String machineIDs, String yarns);

	ArrayList<Machine> searchMachine(String machineCode, String startGauge,
			String endGauge, String equalGauge);

	ArrayList<Yarn> searchYarn(String yarnCode, String startYarnCount,
			String endYarnCount, String equalYarnCount, String type,
			String startPrice, String endPrice, String equalPrice);

	ArrayList<Style> searchStyle(String styleCode, String knitPattern);
	
	List<?> uniqueList(Criteria criteria);

}
