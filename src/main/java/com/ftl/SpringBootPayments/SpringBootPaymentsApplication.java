package com.ftl.SpringBootPayments;

import com.ftl.SpringBootPayments.config.SpringConfig;
import com.ftl.SpringBootPayments.repository.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootPaymentsApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootPaymentsApplication.class, args);
//	}
public static void main(String[] args) {
	try {

		SpringApplication.run(SpringBootPaymentsApplication.class, args);

	} catch (Exception ex) {
		System.out.println("------------------------------------");
		ex.printStackTrace();
	}
}

}
