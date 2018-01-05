package br.com.incident;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class IncidentApplication {

	private static final String ZONE = "America/Sao_Paulo";

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone(ZONE));
	}

	public static void main(String[] args) {
		SpringApplication.run(IncidentApplication.class, args);
	}
}
