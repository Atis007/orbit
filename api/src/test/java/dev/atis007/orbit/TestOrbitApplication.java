package dev.atis007.orbit;

import org.springframework.boot.SpringApplication;

public class TestOrbitApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrbitApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
