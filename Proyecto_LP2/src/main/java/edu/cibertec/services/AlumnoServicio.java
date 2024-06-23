package edu.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Alumno;
import edu.cibertec.repository.AlumnoRepositorio;

@Service
public class AlumnoServicio {

	@Autowired
	private AlumnoRepositorio alumnoRepositorio;
	
	public List<Alumno> listAll(){
		return alumnoRepositorio.findAll();
	}
	
	public void save(Alumno alumno) {
		alumnoRepositorio.save(alumno);
	}
	
	public Alumno get(Long id) {
		return alumnoRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		alumnoRepositorio.deleteById(id);
	}
	
}
