package edu.cibertec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import edu.cibertec.models.Padre;
import edu.cibertec.services.PadreServicio;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PadreControlador {
	
	@Autowired
	private PadreServicio padreServicio;
	
	@RequestMapping("/padres")
	public String mostrarPadres(Model model) {
		List<Padre> listaPadres = padreServicio.listAll();
		model.addAttribute("listaPadres", listaPadres);
		return "padres";
	}
	
	@RequestMapping("/registrarPadre")
	public String mostrarFormularioRegistrarPadre(Model model) {
		Padre padre = new Padre();
		model.addAttribute("padre", padre);
		return "registrarPadre";
	}
	
	@RequestMapping(value="/guardarPadre", method=RequestMethod.POST)
	public String guardarPadre(@ModelAttribute("padre")Padre padre) {
		padreServicio.save(padre);
		return "redirect:/padres";
	}
	
	@RequestMapping("/editarPadre/{id}")
	public ModelAndView mostrarFormularioEditarPadre(@PathVariable(name="id")Long id) {
		ModelAndView modelo = new ModelAndView("editarPadre");
		
		Padre padre = padreServicio.get(id);
		modelo.addObject("padre", padre);
		return modelo;
	}
	
	@RequestMapping("/eliminarPadre/{id}")
	public String eliminarPadre(@PathVariable(name="id")Long id) {
		padreServicio.delete(id);
		return "redirect:/padres";
	}
	
	
}
