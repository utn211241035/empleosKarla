package com.Karla.Medina.Camino.Org.ruta_raiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    public void addResourceHandles(ResourceHandlerRegistry reg){
        reg.addResourceHandler("/logos/**").addResourceLocations("file:c:/Empleados/src/main/resources/static/images/");
    }
}
