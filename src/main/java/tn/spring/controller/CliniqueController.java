package tn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.Clinique;
import tn.spring.service.ICliniqueService;

@RestController
public class CliniqueController {

	@Autowired
	ICliniqueService cliniqueService;
	
	@PostMapping("/add_clinique")
	public Clinique addClinique (@RequestBody Clinique clinique) {
		return cliniqueService.addClinique(clinique);
	}
	

}
