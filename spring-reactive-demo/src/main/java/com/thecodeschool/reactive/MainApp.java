package com.thecodeschool.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		Mono<?> monoString = Mono.just("javatest").log();
		monoString.subscribe(System.out::println);

		SpringApplication.run(MainApp.class, args);
	}

}
