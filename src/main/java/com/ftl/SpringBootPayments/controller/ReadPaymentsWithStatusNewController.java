package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.Logic.ReadPaymentsWithStatusNew;
import com.ftl.SpringBootPayments.repository.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@EnableScheduling
@EnableAsync
@RestController
public class ReadPaymentsWithStatusNewController {
    private ReadPaymentsWithStatusNew readPaymentsWithStatusNew;
    private PaymentDAO paymentDAO;

    @Value("${paymentStatusNew}")
    private String paymentStatusNew;

    @Autowired
    public ReadPaymentsWithStatusNewController(ReadPaymentsWithStatusNew readPaymentsWithStatusNew, PaymentDAO paymentDAO) {
        this.readPaymentsWithStatusNew = readPaymentsWithStatusNew;
        this.paymentDAO = paymentDAO;
    }



    @RequestMapping("/change")
    @Async
    @Scheduled(fixedDelay = 1000)
    public void changeStatus(){
        readPaymentsWithStatusNew.startReading();
//        System.out.println();
//        System.out.println("paymentDAO.selectWithStatus(paymentStatusNew).size() = " + paymentDAO.selectWithStatus(paymentStatusNew).size());
//        System.out.println("paymentDAO.selectAll().size() = " + paymentDAO.selectAll().size());
//        if(paymentDAO.selectWithStatus(paymentStatusNew).size() == 0 & paymentDAO.selectAll().size() != 0){
//            return;
//        }
    }
}
