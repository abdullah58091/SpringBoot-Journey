package com.example.myfirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MyfirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstProjectApplication.class, args);
	}


    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory) {
        return  new MongoTransactionManager(dbFactory  );
    }
}
