package tfc.sdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import tfc.sdr.model.Evento;
import tfc.sdr.service.IEventosService;

@Controller
//@RequestMapping("/eventos") //al clicar en el nav eventos cuando ya estas en eventos lista da error
public class EventosController {
	
	@Autowired
	IEventosService serviceEventos;
	
	@GetMapping("/lista")
	public String mostrarLista(Model model) {
		List<Evento> lista = serviceEventos.buscarTodos();
		model.addAttribute("eventosList", lista);
		return "eventos/listEventos";
	}

}
