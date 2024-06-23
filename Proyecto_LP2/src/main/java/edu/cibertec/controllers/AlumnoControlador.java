package edu.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cibertec.models.Alumno;
import edu.cibertec.services.AlumnoServicio;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlumnoControlador {

	@Autowired
	private AlumnoServicio alumnoServicio;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model model) {
		return "index";
	}
	
	@RequestMapping("/alumnos")
	public String mostrarAlumnos(Model model) {
		List<Alumno> listaAlumnos = alumnoServicio.listAll();
		model.addAttribute("listaAlumnos", listaAlumnos);
		return "alumnos";
	}
	
	@RequestMapping("/registrarAlumno")
	public String mostrarFormularioRegistrarAlumno(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		return "registrarAlumno";
	}
	
	@RequestMapping(value="/guardarAlumno", method=RequestMethod.POST)
	public String guardarAlumno(@ModelAttribute("alumno")Alumno alumno) {
		alumnoServicio.save(alumno);
		return "redirect:/alumnos";
	}
	
	@RequestMapping("/editarAlumno/{id}")
	public ModelAndView mostrarFormularioEditarAlumno(@PathVariable(name="id") Long id) {
		ModelAndView modelo = new ModelAndView("editarAlumno");
		
		Alumno alumno = alumnoServicio.get(id);
		modelo.addObject("alumno", alumno);
		return modelo;
	}
	
	@RequestMapping("/eliminarAlumno/{id}")
	public String elimiarAlumno(@PathVariable(name="id") Long id) {
		alumnoServicio.delete(id);
		return "redirect:/alumnos";
	}
	
}
