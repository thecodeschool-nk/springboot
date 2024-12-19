package com.thecodeschool.configconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RefreshScope
@RestController
public class ConfigConsumerApplication {
	@Value("${limits.maximum}")
	int maximum;

	public static void main(String[] args) {
		SpringApplication.run(ConfigConsumerApplication.class, args);
		System.out.println("maximum: " + new ConfigConsumerApplication().maximum);
	}

	@RequestMapping(value = "/")
	public int getMaximum() {
		return maximum;
	}

}
