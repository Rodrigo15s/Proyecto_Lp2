package edu.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import edu.cibertec.models.Profesor;
import edu.cibertec.services.ProfesorServicio;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfesorControlador {

	@Autowired
	private ProfesorServicio profesorServicio;

	@RequestMapping("/profesores")
	public String mostrarProfesores(Model model) {
		List<Profesor> listaProfesores = profesorServicio.listAll();
		model.addAttribute("listaProfesores", listaProfesores);
		return "profesores";
	}

	@RequestMapping("/registrarProfesor")
	public String mostrarFormularioRegistrarProfesor(Model model) {
		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);
		return "registrarProfesor";
	}

	@RequestMapping(value = "guardarProfesor", method = RequestMethod.POST)
	public String guardarProfesor(@ModelAttribute("profesor") Profesor profesor) {
		profesorServicio.save(profesor);
		return "redirect:/profesores";
	}

	@RequestMapping("/editarProfesor/{id}")
	public ModelAndView mostrarFormularioEditarProfesor(@PathVariable(name = "id") Long id) {
		ModelAndView modelo = new ModelAndView("editarProfesor");

		Profesor profesor = profesorServicio.get(id);
		modelo.addObject("profesor", profesor);
		return modelo;
	}

	@RequestMapping("/eliminarProfesor/{id}")
	public String eliminarProfesor(@PathVariable(name = "id") Long id) {
		profesorServicio.delete(id);
		return "redirect:/profesores";
	}

}
