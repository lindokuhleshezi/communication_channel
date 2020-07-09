package com.channel.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.channel.domain.Patient;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Long>
{	
	Optional<Patient> findByExternalId(String externalID);
	
}
