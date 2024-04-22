package tfc.sdr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String mostrarHome() {
		return "eventos/home";
	}
	
	//#fff8f3 fondo casi blanco scroll
	//#ffdbb0 salmon claro secundario scroll
	//#ff684b salmon fuerte detalles scroll
	//#62e6d4 azul celeste detalles scroll
}

