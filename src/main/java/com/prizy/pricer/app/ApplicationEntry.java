package com.prizy.pricer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages ="com.prizy.pricer.app,com.prizy.pricer.controller,com.prizy.pricer.dto,com.prizy.pricer.service")
@EntityScan("com.prizy.pricer.entity")
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.prizy.pricer.repository")
public class ApplicationEntry {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationEntry.class, args);
	}

}
