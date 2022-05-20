package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.Template;
import com.ftl.SpringBootPayments.repository.PaymentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final PaymentDAO paymentDAO;

    private final ReadFromInitFileController readFromInitFileController;

    @Autowired
    public PaymentController(PaymentDAO paymentDAO, ReadFromInitFileController readFromInitFileController) {
        this.paymentDAO = paymentDAO;
        this.readFromInitFileController = readFromInitFileController;
    }


    @GetMapping("/save")
    public String saveAll() {
        paymentDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "savePayments";

    }

    @GetMapping("/show")
    public String selectAll() {
        List<Payment> payments = paymentDAO.selectAll();
        System.out.println();
        for(Payment p : payments){
            logger.info(p.toString());
            System.out.println(p.toString());
        }
        return paymentDAO.selectAll().toString();

    }

    @GetMapping("/showStatusNew")
    public String selectStatusNew() {
        List<Payment> payments = paymentDAO.selectWithStatus("new");
        for(Payment p : payments){
            System.out.println(p.toString());
        }
        return paymentDAO.selectWithStatus("new").toString();

    }

}
