package tn.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.Medecin;
import tn.spring.service.IMedecinService;

@RestController
public class MedecinController {

	@Autowired
	IMedecinService medecinService;
	
	@PostMapping("/add_medecin/{cliniqueId}")
	public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin,@PathVariable("cliniqueId") Long cliniqueId) {
		return medecinService.addMedecinAndAssignToClinique(medecin, cliniqueId);
	}

}
