package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.api.SimpleCORSFilter;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//SimpleCORSFilter filter =new SimpleCORSFilter();
		//filter.doFilter(req, res, chain);
	}
	
	@Bean 
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				//registry.addMapping("/*").allowedOrigins("*");
				 //registry.addMapping("/**");
	                registry.addMapping("api/**")
	        		.allowedOrigins("http://localhost:8081/")
	        		.allowedMethods("PUT", "DELETE")
	        			.allowedHeaders("origin")
	        		.exposedHeaders("header1", "header2")
	        		.allowCredentials(false).maxAge(3600);
			}
		};
	}

}
