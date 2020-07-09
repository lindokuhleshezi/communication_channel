package com.channel.service;
import java.util.List;


import com.channel.domain.Patient;
import com.channel.exception.ResourceNotFoundException;


public interface PatientService {
	
	List<Patient> findAll();
	Patient findByExternalId(String externalID);
	void save(Patient patient);
	Patient update(String id,Patient patient)throws ResourceNotFoundException;
	void delete(String id) throws ResourceNotFoundException;	
}
