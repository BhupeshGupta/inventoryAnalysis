package com.zist.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machiene")
public class Machiene {

    private Integer id;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MACHIENE_ID", unique = true, nullable = false)
    public Integer getMachieneId() {
	return id;
    }

    public void setMachieneId(Integer id) {
	this.id = id;
    }

}
