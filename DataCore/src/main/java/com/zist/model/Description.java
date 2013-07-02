package com.zist.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Description")

public class Description {

	private Integer descriptionId;
	private String availableSize;
	private String buttonStyle;
	private String color;
	private String accessories;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DESCRIPTION_ID", unique = true, nullable = false)
	public Integer getDescriptionId(){
		return descriptionId;
	}
	
	public void setDescriptionId(Integer id){
		this.descriptionId = id;
	}
	
	@Column(name = "SIZE",length = 25,nullable = false)	
	public String getSize(){
		return availableSize;
	}
	
	public void setSize(String size){
		this.availableSize=size;
	}
	
	@Column(name = "BUTTON_STYLE",length = 25)
	public String getButtonStyle(){
		return buttonStyle;
	}
	
	public void setButtonStyle(String style){
		this.buttonStyle = style;
	}
	
	@Column(name = "COLOR",length = 25)
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	@Column(name = "Accessories",length = 25)
	public String getAccessories(){
		return this.accessories;
	}
	
	public void setAccessories(String accessories){
		this.accessories = accessories;
	}
	
}
