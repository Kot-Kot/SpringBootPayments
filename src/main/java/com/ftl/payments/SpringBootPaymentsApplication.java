package com.ftl.payments;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Log4j2
public class SpringBootPaymentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPaymentsApplication.class, args);
    }
}
