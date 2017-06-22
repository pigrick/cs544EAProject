package cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(value="cs544")
@EnableScheduling
public class SpringEaProjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEaProjectServiceApplication.class, args);
	}
}
