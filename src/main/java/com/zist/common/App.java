package com.zist.common;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zist.dao.SampleDao;
import com.zist.model.Description;
import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;

public class App {

    public static void main(String[] args) {

	final String sampleCode = "A0873";

	System.out.println("Execution started!!");
	ApplicationContext appcontext = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	SampleDao sampleDao = (SampleDao) appcontext.getBean("sampleDao");

	System.out.println("Sample created!!");
	Sample sample = new Sample();
	sample.setSampleCode(sampleCode);
	
	Machine machine1 = new Machine();
	Machine machine2 = new Machine();
	
	
	Set<Machine> machines = new HashSet<Machine>();
	machines.add(machine1);
	machine1.setMachineGauge((double) 102);
	machines.add(machine2);
	machine2.setMachineGauge((double) 22);
	sample.setMachines(machines);
	
	Style style1 = new Style();
	style1.setKnitPattern("Stripped");
	sample.setStyle(style1);
	
	
	Yarn yarn1 = new Yarn();

	Set<Yarn> yarns = new HashSet<Yarn>();
	yarns.add(yarn1);
	yarn1.setYarnCount((double) 23);
	yarn1.setYarnPrice((double) 2.1);
	yarn1.setYarnType("Cotton");
	sample.setYarn(yarns);
	
	
	Description description = new Description();
	description.setAccessories("Broche");
	description.setButtonStyle("Long");
	description.setColor("RED,GREEN");
	description.setSize("M,L,XL");
		
	
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
