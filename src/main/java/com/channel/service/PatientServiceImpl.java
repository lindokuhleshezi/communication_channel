package com.channel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel.dao.PatientDAO;
import com.channel.domain.Patient;
import com.channel.exception.ResourceNotFoundException;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;

	@Override
	public List<Patient> findAll() {
		return this.patientDAO.findAll();
	}

	@Override
	public Patient findByExternalId(String externalId) {

		Optional<Patient> patientData = this.patientDAO.findByExternalId(getId(externalId));
		return patientData.get();
	}

	@Override
	public void save(Patient patient) {
		this.patientDAO.save(patient);

	}

	@Override
	public Patient update(String externalId, Patient patient) throws ResourceNotFoundException {
		Optional<Patient> patientData = this.patientDAO.findByExternalId(getId(externalId));
		if (!patientData.isPresent()) {
			throw new ResourceNotFoundException("");
		}
		patient.setId(patientData.get().getId());
		patientDAO.save(patient);
		return patient;
	}

	@Override
	public void delete(String externalId) throws ResourceNotFoundException {
		Optional<Patient> patientData = this.patientDAO.findByExternalId(getId(externalId));
		if (!patientData.isPresent()) {
			throw new ResourceNotFoundException("patient with does not exist");
		}
		this.patientDAO.delete(patientData.get());

	}

	private String getId(String externalId) {
		if (externalId.contains("|")) {
			String[] split = externalId.split("\\|");
			return split[1];
		}
		return externalId;
	}
}
