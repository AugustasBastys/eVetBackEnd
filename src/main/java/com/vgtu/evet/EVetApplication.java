package com.vgtu.evet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.vgtu.evet")
@EntityScan("com.vgtu.evet.entities")
public class EVetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EVetApplication.class, args);
	}

}
