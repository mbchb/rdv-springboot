package tn.spring.service;

import java.util.Date;
import java.util.List;

import tn.spring.entities.RendezVous;
import tn.spring.entities.Specialite;

public interface IRendezVousService {

	public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

	public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);

	public int getNbrRendezVousMedecin(Long idMedecin);
}
