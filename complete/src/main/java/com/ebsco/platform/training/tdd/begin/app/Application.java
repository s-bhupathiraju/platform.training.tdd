package com.ebsco.platform.training.tdd.begin.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.ebsco.platform.training.tdd.begin.app.model.User;
import com.ebsco.platform.training.tdd.begin.app.repository.UserRepository;
import com.ebsco.platform.training.tdd.begin.config.UserRootConfig;

@SpringBootApplication
@Import({UserRootConfig.class})
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("Chris", "Martin"));
			repository.save(new User("Jonny", "Buckland"));
			repository.save(new User("Guy", "Berryman"));
			repository.save(new User("Will", "Champion"));
			
			// fetch all customers
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			User customer = repository.findOne(1L);
			log.info("User found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("User found with findByLastName('Buckland'):");
			log.info("--------------------------------------------");
			for (User bauer : repository.findByLastName("Buckland")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}
