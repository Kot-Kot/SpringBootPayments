package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.Template;
import com.ftl.SpringBootPayments.repository.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentDAO paymentDAO;

    private final ReadFromInitFileController readFromInitFileController;

    @Autowired
    public PaymentController(PaymentDAO paymentDAO, ReadFromInitFileController readFromInitFileController) {
        this.paymentDAO = paymentDAO;
        this.readFromInitFileController = readFromInitFileController;
    }


    @RequestMapping("/save")
    public String saveAll() {
        paymentDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "savepayments";

    }

    @RequestMapping("/show")
    public String selectAll() {
        List<Payment> payments = paymentDAO.selectAll();
        System.out.println();
        for(Payment p : payments){
            System.out.println(p.toString());
        }
        return paymentDAO.selectAll().toString();

    }

    @RequestMapping("/showStatusNew")
    public String selectStatusNew() {
        List<Payment> payments = paymentDAO.selectWithStatus("new");
        for(Payment p : payments){
            System.out.println(p.toString());
        }
        return paymentDAO.selectWithStatus("new").toString();

    }

    @RequestMapping("/update")
    public void update() {
        paymentDAO.update("paid", paymentDAO.selectAll().get(0).getId());
    }
}
