package tfc.sdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tfc.sdr.model.Evento;
import tfc.sdr.service.IEventosService;

@Controller
public class EventosController {
	
	@Autowired
	IEventosService serviceEventos;
	
	@GetMapping("/lista")
	public String mostrarLista(Model model) {
		List<Evento> lista = serviceEventos.buscarTodos();
		model.addAttribute("eventosList", lista);
		return "eventos/listEventos";
	}

	@GetMapping("/detalle/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Evento evento = serviceEventos.buscarPorId(idVacante);
		model.addAttribute("evento",evento);
		return "eventos/detalle";
	}
	
	@GetMapping("/insertar")
	public String insertarEvento(Evento evento) {
		return "eventos/formEventos";
	}
	
	@PostMapping("/guardar")
	public String guardarEvento(Evento evento) {
		evento.setContador(0);
		serviceEventos.guardarEvento(evento);
		return "redirect:/lista";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idEvento) {
		serviceEventos.eliminar(idEvento);
		System.out.println("borrado");
		return "redirect:/lista";
	}
	
	@GetMapping("/modificar/{id}") //no funciona
	public String modificar(@PathVariable("id") int idEvento, Model model) {
		Evento evento = serviceEventos.buscarPorId(idEvento);
		model.addAttribute("evento",evento);
		return "eventos/formEventos";
	}
}
	

