package tn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.RendezVous;
import tn.spring.entities.Specialite;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

	List<RendezVous> findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(Long idClinique, Specialite specialite);

	// 2ème façon pour implementer la question 5 :
	/*
	 * @Query("SELECT r FROM RendezVous r JOIN r.medecin.cliniques c WHERE c.idClinique =?1 AND r.medecin.specialite =?2"
	 * ) List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique,
	 * Specialite specialite);
	 */

	// 2ème façon pour implementer la question 8 :
	/*
	 * @Query("SELECT r FROM RendezVous r where r.medecin.idMedecin=:idMedecin "
	 * + "and r.dateRdv BETWEEN :date1 and :date2") List<RendezVous>
	 * getRendezVousMedecin(@Param("idMedecin") Long idMedecin, @Param("date1")
	 * Date startDate,
	 * 
	 * @Param("date2")Date endDate);
	 */
	List<RendezVous> findByMedecinIdMedecin(Long idMedecin);

}
