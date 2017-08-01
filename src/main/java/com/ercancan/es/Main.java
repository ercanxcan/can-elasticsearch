package com.ercancan.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ercancan.es.model")
@EnableJpaRepositories(basePackages = "com.ercancan.es.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "com.ercancan.es.repository.elasticsearch")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
