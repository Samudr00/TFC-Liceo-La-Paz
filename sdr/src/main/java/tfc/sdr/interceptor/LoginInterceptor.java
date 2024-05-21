package tfc.sdr.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tfc.sdr.model.Usuario;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    HttpSession session = request.getSession();
	    Usuario usuario = (Usuario) session.getAttribute("usuario");
	    if (usuario == null) {
	        response.sendRedirect("/login");
	        return false;
	    }
	    return true;
	}

}
