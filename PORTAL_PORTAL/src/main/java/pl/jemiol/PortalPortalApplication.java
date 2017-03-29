package pl.jemiol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PortalPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalPortalApplication.class, args);
	}
}
