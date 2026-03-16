package com.gal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
	
	@Bean
	String dirToSearch()
	{
		return "D:\\Capgemini_Training\\Bean-Project\\src\\main\\java\\com\\gal";
	}
	
	@Bean
	String fileFilter()
	{
		return "*.java";
	}
	

}
