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

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MACHINE_ID", unique = true, nullable = false)
    public Integer getMachineId() {
	return id;
    }

    public void setMachineId(Integer id) {
	this.id = id;
    }

}
