package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.models.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{

}
