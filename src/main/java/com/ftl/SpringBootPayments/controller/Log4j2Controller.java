package com.ftl.SpringBootPayments.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4j2Controller {
    private static final Logger LOG = LogManager.getLogger(Log4j2Controller.class);


    @GetMapping(value = "/g")
    public String greeting(){
        LOG.warn("warn");
        LOG.debug("debug");
        LOG.info("info");
        return "Hello!!!";
    }
}
