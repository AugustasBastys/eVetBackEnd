package com.vilniustech.evet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.vilniustech.evet")
@EntityScan("com.vilniustech.evet.entities")
public class EVetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EVetApplication.class, args);
	}

}
