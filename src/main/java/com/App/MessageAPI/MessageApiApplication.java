package com.App.MessageAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.App.MessageAPI"})
public class MessageApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageApiApplication.class, args);
	}

}
