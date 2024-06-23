package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.models.Profesor;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {
	
}
