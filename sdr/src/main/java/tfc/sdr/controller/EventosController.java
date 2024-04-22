package tfc.sdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
}
