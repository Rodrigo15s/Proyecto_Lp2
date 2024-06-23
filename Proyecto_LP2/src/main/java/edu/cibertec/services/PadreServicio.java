package edu.cibertec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Padre;
import edu.cibertec.repository.PadreRepositorio;

@Service
public class PadreServicio {

	@Autowired
	private PadreRepositorio padreRepositorio;
	
	public List<Padre> listAll(){
		return padreRepositorio.findAll();
	}
	
	public void save(Padre padre) {
		padreRepositorio.save(padre);
	}
	
	public Padre get(Long id) {
		return padreRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		padreRepositorio.deleteById(id);
	}
	
}
