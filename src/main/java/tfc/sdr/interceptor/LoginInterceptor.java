package tfc.sdr.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import tfc.sdr.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("/login");
            return false;
        }

        String requestURI = request.getRequestURI();

        if (isRestrictedURI(requestURI) && !hasRequiredRole(usuario, "SUPERVISOR", "ADMINISTRADOR")) {
            response.sendRedirect("/accessDenied");
            return false;
        }

        return true;
    }

    private boolean isRestrictedURI(String uri) {
        return uri.startsWith("/eliminar/") || uri.startsWith("/modificar/");
    }

    private boolean hasRequiredRole(Usuario usuario, String... roles) {
        List<String> userRoles = usuario.getPerfiles().stream()
                                        .map(perfil -> perfil.getPerfil())
                                        .collect(Collectors.toList());
        for (String role : roles) {
            if (userRoles.contains(role)) {
                return true;
            }
        }
        return false;
    }
}
