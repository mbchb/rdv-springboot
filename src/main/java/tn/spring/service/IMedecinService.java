package tn.spring.service;

import tn.spring.entities.Medecin;

public interface IMedecinService {
	public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);
}
