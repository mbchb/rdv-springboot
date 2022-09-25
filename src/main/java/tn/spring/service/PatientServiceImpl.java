package tn.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Patient;
import tn.spring.repository.PatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}
}
