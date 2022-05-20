package com.ftl.SpringBootPayments;

import com.ftl.SpringBootPayments.config.SpringConfig;
import com.ftl.SpringBootPayments.repository.UserDAO;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Log4j2
public class SpringBootPaymentsApplication {
	//private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");


//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootPaymentsApplication.class, args);
//	}
	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";

	}

public static void main(String[] args) {
	try {

		SpringApplication.run(SpringBootPaymentsApplication.class, args);

	} catch (Exception ex) {
		System.out.println("------------------------------------");
		ex.printStackTrace();
	}
}

}
