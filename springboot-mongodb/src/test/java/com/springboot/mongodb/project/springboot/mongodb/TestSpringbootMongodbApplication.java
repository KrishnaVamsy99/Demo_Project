package com.springboot.mongodb.project.springboot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
@TestConfiguration(proxyBeanMethods = false)
public class TestSpringbootMongodbApplication {

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		return new MongoDBContainer(DockerImageName.parse("mongo:latest"));
	}

	public static void main(String[] args) {
		SpringApplication.from(SpringbootMongodbApplication::main).with(TestSpringbootMongodbApplication.class).run(args);
	}

}
