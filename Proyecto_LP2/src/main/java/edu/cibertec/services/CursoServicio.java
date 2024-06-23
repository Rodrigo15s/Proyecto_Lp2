package edu.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Curso;
import edu.cibertec.repository.CursoRepositorio;

@Service
public class CursoServicio {
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	public List<Curso> listAll(){
		return cursoRepositorio.findAll();
	}
	
	public void save(Curso curso) {
		cursoRepositorio.save(curso);
	}
	
	public Curso get(Long id) {
		return cursoRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		cursoRepositorio.deleteById(id);
	}
	
}
