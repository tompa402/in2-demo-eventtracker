package hr.in2.novak.eventtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EventtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventtrackerApplication.class, args);
	}

}
