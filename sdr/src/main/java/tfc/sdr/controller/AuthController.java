package tfc.sdr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import tfc.sdr.model.Usuario;
import tfc.sdr.service.IUsuariosService;

@Controller
public class AuthController {

    @Autowired
    private IUsuariosService serviceUsuarios;

    @GetMapping("/login")
    public String login() {
        return "login/login";  
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, Model model) {
        Usuario usuario = serviceUsuarios.buscarPorUsername(username);
        
        if (usuario != null && usuario.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario); // Almacena el objeto completo del usuario en la sesion
            return "redirect:/";
        }
        
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/crearUsuario")
    public String insertarUsuario(Usuario usuario) {
        return "login/formUsuarios"; 
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuario usuario) {
        serviceUsuarios.guardarUsuario(usuario);
        return "redirect:/login";
    }
}
