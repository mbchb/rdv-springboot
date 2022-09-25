package tn.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Clinique;
import tn.spring.entities.Medecin;
import tn.spring.repository.CliniqueRepository;
import tn.spring.repository.MedecinRepository;

@Service
public class MedecinServiceImpl implements IMedecinService {

	@Autowired
	CliniqueRepository cliniqueRepository;

	@Autowired
	MedecinRepository medecinRepository;

	@Override
	@Transactional
	public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
		Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);
		clinique.getMedecins().add(medecin);
		return medecinRepository.save(medecin);
	}

}
