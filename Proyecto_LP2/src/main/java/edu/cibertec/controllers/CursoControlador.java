package edu.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import edu.cibertec.models.Curso;
import edu.cibertec.services.CursoServicio;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursoControlador {
	
	@Autowired
	
	private CursoServicio cursoServicio;
	
	@RequestMapping("/cursos")
	public String mostrarCursos(Model model) {
		List<Curso> listaCursos = cursoServicio.listAll();
		model.addAttribute("listaCursos", listaCursos);
		return "cursos";
	}
	
	@RequestMapping("/registrarCurso")
	public String mostrarFormularioRegistrarCurso(Model model) {
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		return "registrarCurso";
	}
	
	@RequestMapping(value="/guardarCurso", method=RequestMethod.POST)
	public String guardarCurso(@ModelAttribute("curso")Curso curso) {
		cursoServicio.save(curso);
		return "redirect:/cursos";
	}
	
	@RequestMapping("/editarCurso/{id}")
	public ModelAndView mostrarFormularioEditarCurso(@PathVariable(name="id")Long id) {
		ModelAndView modelo = new ModelAndView("editarCurso");
		
		Curso curso = cursoServicio.get(id);
		modelo.addObject("curso", curso);
		return modelo;
	}
	
	@RequestMapping("/eliminarCurso/{id}")
	public String requestMethodName(@PathVariable(name="id")Long id) {
		cursoServicio.delete(id);
		return "redirect:/cursos";
	}
	
	
}
