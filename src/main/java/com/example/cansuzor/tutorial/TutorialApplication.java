package com.example.cansuzor.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
@SpringBootApplication
@ComponentScan("com.example.cansuzor.tutorial") //asking spring to detect spring components
@EntityScan("com.example.cansuzor.tutorial.model")
public class TutorialApplication {
	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

}
