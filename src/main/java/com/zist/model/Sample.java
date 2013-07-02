package com.zist.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
public class Sample implements java.io.Serializable {
    private static final long serialVersionUID = -7849706515718080288L;
    
    private Integer sampleId;
    private String sampleCode;
    private String category;
    private Float popularity;
    private String year;
    private Float weight;
    private Float price;
    private String view;
    private String designFile;
    private String gender;
    private Set<Machine> machineTimings;

    public Sample() {
    }

    public Sample(String sampleCode, String stockName) {
	this.sampleCode = sampleCode;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SAMPLE_ID", unique = true, nullable = false)
    public Integer getStockId() {
	return this.sampleId;
    }

    public void setStockId(Integer stockId) {
	this.sampleId = stockId;
    }

    @Column(name = "SAMPLE_CODE", unique = true, nullable = false, length = 10)
    public String getSampleCode() {
	return this.sampleCode;
    }

    public void setSampleCode(String stockCode) {
	this.sampleCode = stockCode;
    }

    @Column(name = "SAMPLE_CATEGORY", unique = false)
    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    @Column(name = "SAMPLE_POPULARITY", unique = false)
    public Float getPopularity() {
	return popularity;
    }

    public void setPopularity(Float popularity) {
	this.popularity = popularity;
    }
    
    @Column(name = "SAMPLE_YEAR", unique = false)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "SAMPLE_WEIGHT", unique = false)
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Column(name = "SAMPLE_PRICE", unique = false)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column(name = "SAMPLE_VIEW", unique = true)
    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Column(name = "SAMPLE_DESIGNFILE", unique = true)
    public String getDesignfile() {
        return designFile;
    }

    public void setDesignfile(String designfile) {
        this.designFile = designfile;
    }

    @Column(name = "SAMPLE_GENDER", unique = false, length = 6)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "machiene_id")
    public Set<Machine> getMachines() {
        return machineTimings;
    }

    public void setMachines(Set<Machine> machineTimings) {
        this.machineTimings = machineTimings;
    }
    
    @Override
    public String toString() {
	return "Sample [sampleCode=" + sampleCode + ", sampleId=" + sampleId
		+  "]";
    }
}