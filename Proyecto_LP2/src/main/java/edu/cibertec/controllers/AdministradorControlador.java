package edu.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cibertec.models.Administrador;
import edu.cibertec.services.AdministradorServicio;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdministradorControlador {

	@Autowired
	private AdministradorServicio administradorServicio;
	
	
	@RequestMapping("/administradores")
	public String mostrarAdministradores(Model model) {
		List<Administrador> listaAdministradores = administradorServicio.listAll();
		model.addAttribute("listaAdministradores", listaAdministradores);
		return "administradores";
	}
	
	@RequestMapping("/registrarAdministrador")
	public String mostrarFormularioRegistrarAdministrador(Model model) {
		Administrador administrador = new Administrador();
		model.addAttribute("administrador", administrador);
		return "registrarAdministrador";
	}
	
	@RequestMapping(value="/guardarAdministrador", method=RequestMethod.POST)
	public String guardarAdministrador(@ModelAttribute("administrador")Administrador administrador) {
		administradorServicio.save(administrador);
		return "redirect:/administradores";
	}
	
	@RequestMapping("/editarAdministrador/{id}")
	public ModelAndView mostrarFormularioEditarAdministrador(@PathVariable(name="id")Long id) {
		ModelAndView modelo = new ModelAndView("editarAdministrador");
		
		Administrador administrador = administradorServicio.get(id);
		modelo.addObject("administrador", administrador);
		return modelo;
	}
	
	@RequestMapping("/eliminarAdministrador/{id}")
	public String eliminarAdministrador(@PathVariable(name="id")Long id) {
		administradorServicio.delete(id);
		return "redirect:/administradores";
	}
	
	
	
	
	
}
