package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.models.Alumno;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long> {

}
