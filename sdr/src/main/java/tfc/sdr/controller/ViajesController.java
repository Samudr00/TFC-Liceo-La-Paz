package tfc.sdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tfc.sdr.model.Evento;
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
    
	@GetMapping("/detalleViajes/{id}")
	public String verDetalle(@PathVariable("id") int idViaje, Model model) {
		Viaje viaje = serviceViajes.buscarPorId(idViaje);
		model.addAttribute("viaje",viaje);
		return "viajes/detalleViajes";
	}
	
	@GetMapping("/insertarViaje")
	public String insertarViaje(Viaje viaje) {
		return "viajes/formViajes";
	}
	
	@PostMapping("/guardarViaje")
	public String guardarViaje(Viaje viaje) {
		serviceViajes.guardarViaje(viaje);
		return "redirect:/listaViajes";
	}
	
	@GetMapping("/eliminarViaje/{id}")
	public String eliminarViaje(@PathVariable("id") int idViaje) {
		serviceViajes.eliminarViaje(idViaje);
		System.out.println("borrado");
		return "redirect:/listaViajes";
	}
	
	@GetMapping("/modificarViaje/{id}") 
	public String modificarViaje(@PathVariable("id") int idViaje, Model model) {
		Viaje viaje = serviceViajes.buscarPorId(idViaje);
		model.addAttribute("viaje",viaje);
		return "viajes/formViajes";
	}
	
	@GetMapping("/buscarPorPresupuesto")
	public String buscarPorPresupuesto(@RequestParam("presupuestoMinimo") Integer presupuestoMinimo, 
	                                   @RequestParam("presupuestoMaximo") Integer presupuestoMaximo,
	                                   Model model) {
	    List<Viaje> lista = serviceViajes.buscarPorPresupuesto(presupuestoMinimo, presupuestoMaximo);
	    model.addAttribute("viajesList", lista);
		System.out.println(lista);
	    return "viajes/listViajes"; 
	}
}
