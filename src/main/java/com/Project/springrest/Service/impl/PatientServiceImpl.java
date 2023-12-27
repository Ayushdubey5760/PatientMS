package com.Project.springrest.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Project.springrest.Entites.Patient;
import com.Project.springrest.Exception.ResourceNotFoundException;
import com.Project.springrest.Repository.PatientRepo;
import com.Project.springrest.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepo PatientRepository;
	
	public PatientServiceImpl(PatientRepo patientRepo) {
		super();
		this.PatientRepository = patientRepo;
	}
	
	@Override
	public Patient savePatient(Patient patient) {
		return PatientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		return PatientRepository.findAll();
	}

	@Override
	public Patient getPatientById(long id) {
		Optional<Patient> patient=PatientRepository.findById(id);
		if(patient.isPresent()) {
			return patient.get();
		}else {
			throw new ResourceNotFoundException("Patient", "Id", id);
		}
	}

	@Override
	public Patient updatePatient(Patient patient) {
		
		PatientRepository.save(patient);
		return patient;
	}

	@Override
	public void deletePaitient(long id) {
		//we will check id exist or not
		PatientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Id", id));
		PatientRepository.deleteById(id);
	}

	
}
