package com.rovergames;

import com.rovergames.example.entities.Configuration;
import com.rovergames.example.entities.User;
import com.rovergames.example.repositories.ConfigurationRepository;
import com.rovergames.example.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.rovergames.example.repositories")
@EntityScan("com.rovergames.example.entities")
@ComponentScan({"com.rovergames.example.controllers", "com.rovergames.example.services"})
public class ConfigurationServicesApplication {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationServicesApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServicesApplication.class, args);
    }

    @Bean
    public CommandLineRunner buildTestData (UserRepository userRepository, ConfigurationRepository configurationRepository) {
        return (args) -> {
            // save a couple of users
            userRepository.save(new User("Richa", "richa", "test123"));
            userRepository.save(new User("That Guy", "thatguy", "test123"));
            userRepository.save(new User("That Gal", "thatgal", "test123"));

            configurationRepository.save(buildTestConfigurations(30));

        };
    }

    private List<Configuration> buildTestConfigurations (int numberOfConfigs) {
        List<Configuration> configurations = new ArrayList<>(numberOfConfigs);

        for (int i = 1; i <= numberOfConfigs; i++) {
            Configuration configuration = new Configuration("host" + i, "test" + i + ".lab.com", 5000 + i, "test" + i);

            if(i < 10) {
                configuration.setCommonProperty("something1");
            } else {
                configuration.setCommonProperty("something10");
            }

            configurations.add(configuration);
        }

        return configurations;

    }
}
