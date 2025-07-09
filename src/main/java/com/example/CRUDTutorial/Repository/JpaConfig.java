package com.example.CRUDTutorial.Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.CRUDTutorial.Repository")
public class JpaConfig {

}
