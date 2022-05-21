package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.Logic.ReadPaymentsWithStatusNew;
import com.ftl.SpringBootPayments.repository.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RestController
public class ReadPaymentsWithStatusNewController {
    private ReadPaymentsWithStatusNew readPaymentsWithStatusNew;
    private PaymentDAO paymentDAO;

    @Autowired
    public ReadPaymentsWithStatusNewController(ReadPaymentsWithStatusNew readPaymentsWithStatusNew, PaymentDAO paymentDAO) {
        this.readPaymentsWithStatusNew = readPaymentsWithStatusNew;
        this.paymentDAO = paymentDAO;
    }

    @GetMapping("/change")
    public void changeStatus(){
        readPaymentsWithStatusNew.startReading();
    }
}
