package com.zist.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.zist.controller.SampleController;
import com.zist.controller.TestController;

@Configurable
public class App {

	@Autowired
	static SampleController sampleController;
	
	public static void main(String[] args) {
		
		TestController testController = new TestController();
		testController.getTestData();


	}

}
