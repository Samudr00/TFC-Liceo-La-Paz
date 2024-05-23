package tfc.sdr.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import tfc.sdr.model.Usuario;
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
        return "viajes/listViajes";
    }

    @GetMapping("/detalleViajes/{id}")
    public String verDetalle(@PathVariable("id") int idViaje, Model model, HttpSession session) {
        Viaje viaje = serviceViajes.buscarPorId(idViaje);
        model.addAttribute("viaje", viaje);

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            List<String> roles = usuario.getPerfiles().stream()
                                        .map(perfil -> perfil.getPerfil())
                                        .collect(Collectors.toList());
            model.addAttribute("roles", roles);
        }
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
        return "redirect:/listaViajes";
    }

    @GetMapping("/modificarViaje/{id}") 
    public String modificarViaje(@PathVariable("id") int idViaje, Model model) {
        Viaje viaje = serviceViajes.buscarPorId(idViaje);
        model.addAttribute("viaje", viaje);
        return "viajes/formViajes";
    }

    @GetMapping("/buscarPorPresupuesto")
    public String buscarPorPresupuesto(@RequestParam("presupuestoMinimo") Integer presupuestoMinimo, 
                                       @RequestParam("presupuestoMaximo") Integer presupuestoMaximo,
                                       Model model) {
        List<Viaje> lista = serviceViajes.buscarPorPresupuesto(presupuestoMinimo, presupuestoMaximo);
        model.addAttribute("viajesList", lista);
        return "viajes/listViajes"; 
    }

    @ModelAttribute
    public void setGenericos(Model model) {
        Viaje viajeSearch = new Viaje();
        model.addAttribute("viajes", serviceViajes.buscarTodos());
        model.addAttribute("search", viajeSearch);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
