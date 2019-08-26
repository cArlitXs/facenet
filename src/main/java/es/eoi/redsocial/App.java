package es.eoi.redsocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "es.eoi.redsocial")
@EntityScan( basePackages = {"es.eoi.redsocial"} )
@ComponentScan(basePackages = "es.eoi.redsocial")

public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
