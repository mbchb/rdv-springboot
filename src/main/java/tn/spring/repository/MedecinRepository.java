package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
