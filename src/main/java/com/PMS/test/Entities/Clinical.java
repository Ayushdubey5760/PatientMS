package com.PMS.test.Entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Clinical {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clinicalid;
	
	private String height;
	
	private String weight;

	@Fetch(FetchMode.JOIN)
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="allergy_id")
	@JsonBackReference
	private Allergies allergy;
	
	
	
	
	
	
	public int getClinicalid() {
		return clinicalid;
	}

	public void setClinicalid(int clinicalid) {
		this.clinicalid = clinicalid;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Clinical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clinical(int clinicalid, String height, String weight) {
		super();
		this.clinicalid = clinicalid;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Clinical [clinicalid=" + clinicalid + ", height=" + height + ", weight=" + weight + "]";
	}

	public Allergies getAllergy() {
		return allergy;
	}

	public void setAllergy(Allergies allergy) {
		this.allergy = allergy;
	}


}
