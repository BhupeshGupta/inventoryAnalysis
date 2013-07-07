package com.zist.service;

import com.zist.model.Description;

public interface DescriptionService {

	public void save(Description description);
	public void update(Description description);
	public void delete(Description description);
	
	Description findByDescriptionID(String descriptionID);
}
