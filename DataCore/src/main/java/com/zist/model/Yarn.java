package com.zist.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="yarn")

public class Yarn {

	private Integer yarnId;
	private String yarnCode;
	private Float yarnCount;
	private String type;
	private Float price;
	
@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "Yarn_ID", unique = true, nullable = false)
public Integer getYarnId(){
	return yarnId;
}

public void setYarnId(Integer id){
	this.yarnId = id;
}

@Column(name = "YARN_COUNT" , unique = false , nullable = false)
public Float getYarnCount(){
	return yarnCount;
}

public void setYarnCount(Float count){
	this.yarnCount = count;
}

@Column(name = "YARN_TYPE" , unique = false , nullable = false , length = 15)
public String getYarnType(){
	return type;
}

public void setYarnType(String type){
	this.type = type;
}

@Column(name = "YARN_PRICE" , unique = false )
public Float getYarnPrice(){
	return price;
}

public void setYarnPrice(Float price){
	this.price = price;
}

@Column(name = "YARN_CODE")
public String getYarnCode() {
	return yarnCode;
}

public void setYarnCode(String yarnCode) {
	this.yarnCode = yarnCode;
}
}
