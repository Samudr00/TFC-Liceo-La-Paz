package tfc.sdr.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tfc.sdr.interceptor.LoginInterceptor;
import tfc.sdr.interceptor.RoleInterceptor;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/lista", "/listaViajes", "/filtrarVerificados","/buscarPorPresupuesto","/detalle/**","/detalleViajes/**", "/search", "/searchViajes", "/login", "/usuarios/guardar", "/crearUsuario", "/css/**", "/js/**", "/images/**");

        registry.addInterceptor(new RoleInterceptor(Arrays.asList("ADMINISTRADOR", "SUPERVISOR")))
                .addPathPatterns("/eliminar/**", "/modificar/**")
                .addPathPatterns("/eliminarViaje/**", "/modificarViaje/**");
    }
}
