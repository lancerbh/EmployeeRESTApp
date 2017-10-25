
/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package br.com.meetup.bh;

import java.util.Optional;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class App {

	// Get PORT and HOST from Environment or set default
	public static final Optional<String> HOST;
	public static final Optional<String> PORT;
	public static final Properties PROPS = new Properties();

	static {
		HOST = Optional.ofNullable(System.getenv("HOSTNAME"));
		PORT = Optional.ofNullable(System.getenv("PORT"));
	}

	public static void main(String[] args) {
		// Set properties

		PROPS.setProperty("server.address", HOST.orElse("localhost"));
		PROPS.setProperty("server.port", PORT.orElse("8080"));

		SpringApplication app = new SpringApplication(App.class);
		app.setDefaultProperties(PROPS);
		app.run(args);

	}
}