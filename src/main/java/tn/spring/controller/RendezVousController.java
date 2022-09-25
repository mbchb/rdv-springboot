package tn.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.RendezVous;
import tn.spring.entities.Specialite;
import tn.spring.service.IRendezVousService;

@RestController
public class RendezVousController {

	@Autowired
	IRendezVousService rdvService;

	@PostMapping("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
	public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable("idMedecin") Long idMedecin,
			@PathVariable("idPatient") Long idPatient) {
		rdvService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
	}

	@GetMapping("/getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("idClinique") Long idClinique,
			@PathVariable("specialite") Specialite specialite) {
		return rdvService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
	}

	@GetMapping("/getNbrRendezVousMedecin/{idMedecin}")
	public int getNbrRendezVousMedecin(@PathVariable("idMedecin") Long idMedecin) {
		return rdvService.getNbrRendezVousMedecin(idMedecin);
	}

	@GetMapping("/getRevenuMedecin/{idMedecin}")
	public int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
			@RequestParam Date startDate,
			@RequestParam Date endDate) {
		return rdvService.getRevenuMedecin(idMedecin, startDate, endDate);
	}
}
