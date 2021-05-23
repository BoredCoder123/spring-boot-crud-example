package spring.boot.crud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.boot.crud.example.Formatter.LogFormatter;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

@SpringBootApplication
public class SpringBootCrudExampleApplication {

	private final static Logger logger = Logger.getLogger(SpringBootCrudExampleApplication.class.getName());

	@PostConstruct
	private void init(){
		logger.setUseParentHandlers(false);

		ConsoleHandler handler = new ConsoleHandler();



		LogFormatter formatter = new LogFormatter();
		handler.setFormatter(formatter);

		logger.addHandler(handler);
	}

	public static void main(String[] args) {
		logger.info("In SpringBootCrudExampleApplication class");
		SpringApplication.run(SpringBootCrudExampleApplication.class, args);
	}
}
