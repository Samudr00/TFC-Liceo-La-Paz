package tfc.sdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tfc.sdr.model.Viaje;
import tfc.sdr.service.IViajesService;

@Controller
public class ViajesController {
	
	@Autowired
	IViajesService serviceViajes;

    @GetMapping("/listaViajes")
    public String mostrarLista(Model model) {
        List<Viaje> lista = serviceViajes.buscarTodos();
        model.addAttribute("viajesList", lista);
        //model.addAttribute("search", new Evento()); 
        return "viajes/listViajes";
    }
}
