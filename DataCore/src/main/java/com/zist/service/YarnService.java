package com.zist.service;

import com.zist.model.Yarn;;

public interface YarnService {

	public void save(Yarn yarn);
	public void update(Yarn yarn);
	public void delete(Yarn yarn);
	
	Yarn findByYarnCode(String yarnCode);
	Yarn findByYarnID(String yarnID);
}
