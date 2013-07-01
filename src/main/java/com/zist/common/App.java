package com.zist.common;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zist.dao.SampleDao;
import com.zist.model.Machiene;
import com.zist.model.Sample;

public class App {

    public static void main(String[] args) {

	final String sampleCode = "A0873";

	System.out.println("Execution started!!");
	ApplicationContext appcontext = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	SampleDao sampleDao = (SampleDao) appcontext.getBean("sampleDao");

	System.out.println("Sample created!!");
	Sample sample = new Sample();
	sample.setStockCode(sampleCode);
	
	Machiene machiene1 = new Machiene();
	Machiene machiene2 = new Machiene();
	
	Set<Machiene> machienes = new HashSet<Machiene>();
	machienes.add(machiene1);
	machienes.add(machiene2);
	
	sample.setMachienes(machienes);
	
	try {
	    sampleDao.save(sample);
	    System.out.println("Sample saved!!");
	} catch (ConstraintViolationException e) {
	    System.out.println("Sample already exists, deleting it!!");
	    sampleDao.delete(sampleDao.findBySampleCode(sampleCode));
	    System.out.println("Recreating sample!!");
	    sampleDao.save(sample);
	    System.out.println("Sample saved!!");
	} finally {
	    System.out.println("Done!!");
	}
    }
}
