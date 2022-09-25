package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Clinique;

@Repository
public interface CliniqueRepository extends JpaRepository<Clinique, Long> {

}
