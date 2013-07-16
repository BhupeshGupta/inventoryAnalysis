package com.zist.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machine")
public class Machine {

    private Integer id;
    private String machineCode;
    private Float machineGauge;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MACHINE_ID", unique = true, nullable = false)
    public Integer getMachineId() {
	return id;
    }
    
    public void setMachineId(Integer id) {
	this.id = id;
    }

    @Column(name = "MACHINE_GAUGE" , unique = false , nullable = false)
    public Float getMachineGauge(){
    return machineGauge;	
    }
    
    public void setMachineGauge(Float gauge){
    this.machineGauge = gauge;	
    }

    @Column(name = "MACHINE_CODE",unique = true, nullable = false)
	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}
}
