package edu.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Administrador;
import edu.cibertec.repository.AdministradorRepositorio;

@Service
public class AdministradorServicio {

	@Autowired
	private AdministradorRepositorio administradorRepositorio;
	
	public List<Administrador> listAll(){
		return administradorRepositorio.findAll();
	}
	
	public void save(Administrador administrador) {
		administradorRepositorio.save(administrador);
	}
	
	public Administrador get(Long id) {
		return administradorRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		administradorRepositorio.deleteById(id);
	}
	
}
