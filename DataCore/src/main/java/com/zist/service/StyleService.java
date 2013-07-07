package com.zist.service;

import com.zist.model.Style;;

public interface StyleService {

	public void save(Style style);
	public void update(Style style);
	public void delete(Style style);
	
	Style findByStyleCode(String styleCode);
	Style findByStyleID(String styleID);
}
