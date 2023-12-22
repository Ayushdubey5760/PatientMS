 package com.PMS.test.Entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Allergies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergyid;
	
	private String category;
	
	private String clinical_status;
	
	private String severity;
	
	@Fetch(FetchMode.JOIN)
	@OneToOne(mappedBy = "allergy",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Clinical clinical;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClinical_status() {
		return clinical_status;
	}

	public void setClinical_status(String clinical_status) {
		this.clinical_status = clinical_status;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Allergies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Allergies(String category, String clinical_status, String severity) {
		super();
		this.category = category;
		this.clinical_status = clinical_status;
		this.severity = severity;
	}

	@Override
	public String toString() {
		return "Allergies [category=" + category + ", clinical_status=" + clinical_status + ", severity=" + severity
				+ "]";
	}

	public int getAllergyid() {
		return allergyid;
	}

	public void setAllergyid(int allergyid) {
		this.allergyid = allergyid;
	}

	public Clinical getClinical() {
		return clinical;
	}

	public void setClinical(Clinical clinical) {
		this.clinical = clinical;
	}
	
}
