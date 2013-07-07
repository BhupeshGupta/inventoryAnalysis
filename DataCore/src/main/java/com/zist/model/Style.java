package com.zist.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Style")

public class Style {

	private Integer styleId;
	private String  styleCode;
	private String  knitPattern;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STYLE_ID", unique = true, nullable = false)
	public Integer getStyleId(){
		return styleId;
	}
	
	public void setStyleId(Integer id){
		this.styleId = id;
	}
	
	@Column(name = "KNIT_PATTERN",length = 15)
	public String getKnitPattern(){
		return knitPattern;
	}
	
	public void setKnitPattern(String pattern){
		this.knitPattern = pattern;
	}

	public String getStyleCode() {
		return styleCode;
	}

	public void setStyleCode(String styleCode) {
		this.styleCode = styleCode;
	}
}
