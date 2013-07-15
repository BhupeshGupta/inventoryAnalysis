package com.zist.common;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zist.model.Machine;
import com.zist.model.Sample;
import com.zist.model.Style;
import com.zist.model.Yarn;
import com.zist.service.SampleService;

public class App {

    public static void main(String[] args) {

	final String sampleCode = "A0873";

	System.out.println("Execution started!!");
	ApplicationContext appcontext = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	
	SampleService sampleService = (SampleService) appcontext.getBean("sampleService");
	
	System.out.println("Sample created!!");
	
	Sample sample = new Sample();
	sample.setSampleCode(sampleCode);
	
	Machine machine1 = new Machine();
	Machine machine2 = new Machine();
	
	
	Set<Machine> machines = new HashSet<Machine>();
	machines.add(machine1);
	machine1.setMachineGauge((float) 102);
	machines.add(machine2);
	machine2.setMachineGauge((float) 22);
	sample.setMachines(machines);
	
	Style style1 = new Style();
	style1.setKnitPattern("Stripe");
	sample.setStyle(style1);
	
	
	Yarn yarn1 = new Yarn();

	Set<Yarn> yarns = new HashSet<Yarn>();
	yarns.add(yarn1);
	yarn1.setYarnCount((float) 23);
	yarn1.setYarnPrice((float) 2.1);
	yarn1.setYarnType("Cotton");
	sample.setYarn(yarns);
	
	

		
	
	try {
	    sampleService.save(sample);
	    System.out.println("Sample saved!!");
	} catch (ConstraintViolationException e) {
	    System.out.println("Sample already exists, deleting it!!");
	    sampleService.delete(sampleService.findBySampleCode(sampleCode));
	    System.out.println("Recreating sample!!");
	    sampleService.save(sample);
	    System.out.println("Sample saved!!");
	} finally {
	    System.out.println("Done!!");
	}
    }
}
