package com.channel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.channel.domain.Patient;
import com.channel.exception.ResourceNotFoundException;
import com.channel.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping
	public List<Patient> getPatients() {
		return this.patientService.findAll();
	}

	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable String id) {
		return this.patientService.findByExternalId(id);
	}

	@PostMapping
	public void save(@RequestBody Patient patient) {
		this.patientService.save(patient);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable String id) throws ResourceNotFoundException {
		this.patientService.delete(id);
	}

	@PutMapping("/update/{id}")
	public Patient update(@PathVariable String externalId, @RequestBody Patient patient)
			throws ResourceNotFoundException {
		return this.patientService.update(externalId, patient);
	}

}
