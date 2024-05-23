package tfc.sdr.interceptor;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import tfc.sdr.model.Usuario;
import tfc.sdr.model.Perfil;

public class RoleInterceptor implements HandlerInterceptor {
    private List<String> allowedRoles;

    public RoleInterceptor(List<String> allowedRoles) {
        this.allowedRoles = allowedRoles;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("/login");
            return false;
        }

        for (Perfil perfil : usuario.getPerfiles()) {
            if (allowedRoles.contains(perfil.getPerfil())) {
                return true;
            }
        }

        response.sendRedirect("/accessDenied");
        return false;
    }
}
