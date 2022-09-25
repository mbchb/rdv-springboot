package tn.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medecin implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedecin;
	private String nomMedecin;
	private int telephone;
	private int prixConsultation;
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	
	@ManyToMany(mappedBy="medecins")
	@JsonIgnore
	private Set<Clinique> cliniques;

	@OneToMany(mappedBy="medecin")
	@JsonIgnore
	private Set<RendezVous> rdvs;
}
