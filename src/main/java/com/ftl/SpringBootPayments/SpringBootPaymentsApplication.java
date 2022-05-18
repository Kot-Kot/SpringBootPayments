package com.ftl.SpringBootPayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
