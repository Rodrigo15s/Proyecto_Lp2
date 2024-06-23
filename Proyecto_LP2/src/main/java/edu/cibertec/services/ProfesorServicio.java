package edu.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Profesor;
import edu.cibertec.repository.ProfesorRepositorio;

@Service
public class ProfesorServicio {

	@Autowired
	private ProfesorRepositorio profesorRepositorio;
	
	public List<Profesor> listAll(){
		return profesorRepositorio.findAll();
	}
	
	public void save(Profesor profesor) {
		profesorRepositorio.save(profesor);
	}
	
	public Profesor get(Long id) {
		return profesorRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		profesorRepositorio.deleteById(id);
	}
	
}
