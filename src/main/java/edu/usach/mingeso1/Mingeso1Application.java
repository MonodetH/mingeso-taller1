package edu.usach.mingeso1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"edu.usach.mingeso1.*"})
public class Mingeso1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mingeso1Application.class, args);
	}
}

