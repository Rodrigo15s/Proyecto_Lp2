package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.models.Administrador;

public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {

}
