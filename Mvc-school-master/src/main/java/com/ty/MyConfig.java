package com.ty;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class MyConfig {

	@Bean
	public EntityManagerFactory getEMF() {
		return Persistence.createEntityManagerFactory("prashi");
	}
}
