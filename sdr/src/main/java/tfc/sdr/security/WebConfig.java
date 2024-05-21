package tfc.sdr.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tfc.sdr.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // Intercepta todas las rutas
                .excludePathPatterns("/","/lista","/listaViajes","/filtrarVerificados","/search","/buscarPorPresupuesto","/login", "/usuarios/guardar", "/crearUsuario", "/css/**", "/js/**", "/images/**"); // Excluye el login y recursos estáticos
    }
}
