package tn.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.spring.entities.Medecin;
import tn.spring.entities.Patient;
import tn.spring.entities.RendezVous;
import tn.spring.entities.Specialite;
import tn.spring.repository.MedecinRepository;
import tn.spring.repository.PatientRepository;
import tn.spring.repository.RendezVousRepository;

@Slf4j
@Service
public class RendezVousServiceImpl implements IRendezVousService {

	@Autowired
	RendezVousRepository rdvRepository;

	@Autowired
	MedecinRepository medecinRepository;

	@Autowired
	PatientRepository patientRepository;

	@Override
	public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
		Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
		Patient patient = patientRepository.findById(idPatient).orElse(null);
		rdv.setMedecin(medecin);
		rdv.setPatient(patient);
		rdvRepository.save(rdv);		
	}


	@Override
	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
		return rdvRepository.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique, specialite);
	}
	
	@Override
	public int getNbrRendezVousMedecin(Long idMedecin) {
		return rdvRepository.findByMedecinIdMedecin(idMedecin).size();
	}
	
	@Override
	public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
		int somme=0;
		Medecin m = medecinRepository.findById(idMedecin).get();
		for (RendezVous rdv : m.getRdvs()) {
			if (rdv.getDateRdv().after(startDate) && rdv.getDateRdv().before(endDate) ) {
				somme+= rdv.getMedecin().getPrixConsultation();
			}
		}
		return somme;
	}
	
	@Scheduled(cron = "* */15 * * * *")
	public void retriveRend_vous() {
		List<RendezVous> rdvs = rdvRepository.findAll();
		for (RendezVous RendezVous : rdvs) {
			if (RendezVous.getDateRdv().after(new Date()))
				log.info("La liste des RendezVous : " + RendezVous.getDateRdv() + " : Medecin :"
						+ RendezVous.getMedecin().getNomMedecin() + " : Patient :"
						+ RendezVous.getPatient().getNomPatient());
		}
	}

}
