	package tfc.sdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("search", new Evento()); 
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
	
	@GetMapping("/modificar/{id}") 
	public String modificar(@PathVariable("id") int idEvento, Model model) {
		Evento evento = serviceEventos.buscarPorId(idEvento);
		model.addAttribute("evento",evento);
		return "eventos/formEventos";
	}
	
    @GetMapping("/search")
    public String buscar(@ModelAttribute("search") Evento evento, Model model) {
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("nombre", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Evento> example = Example.of(evento, matcher);
        List<Evento> lista = serviceEventos.buscarByExample(example);
        model.addAttribute("eventosList", lista); 
        return "eventos/listEventos";
    }
    
    @GetMapping("/filtrarVerificados")
    public String filtrarVerificados(Model model) {
        List<Evento> listaVerificados = serviceEventos.buscarEventosVerificados();
        model.addAttribute("eventosList", listaVerificados);
        model.addAttribute("search", new Evento());
        return "eventos/listEventos";
    }
	
	@ModelAttribute
	public void setGenericos(Model model) {
		Evento eventoSearch = new Evento();
		model.addAttribute("eventos", serviceEventos.buscarTodos());
		model.addAttribute("search", eventoSearch);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
	

