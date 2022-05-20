package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.Logic.ReadPaymentsWithStatusNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@EnableAsync
@RestController
public class ReadPaymentsWithStatusNewController {
    private ReadPaymentsWithStatusNew readPaymentsWithStatusNew;

    @Autowired
    public ReadPaymentsWithStatusNewController(ReadPaymentsWithStatusNew readPaymentsWithStatusNew) {
        this.readPaymentsWithStatusNew = readPaymentsWithStatusNew;
    }

    @RequestMapping("/change")
    @Async
    @Scheduled(fixedRate = 1000)
    public void changeStatus(){
        readPaymentsWithStatusNew.startReading();
    }
}
