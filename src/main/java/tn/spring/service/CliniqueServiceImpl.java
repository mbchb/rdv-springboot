package tn.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Clinique;
import tn.spring.repository.CliniqueRepository;

@Service
public class CliniqueServiceImpl implements ICliniqueService {

	@Autowired
	CliniqueRepository cliniqueRepository;

	@Override
	public Clinique addClinique(Clinique clinique) {
		return cliniqueRepository.save(clinique);
	}

}
