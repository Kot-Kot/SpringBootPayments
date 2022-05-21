package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.Template;
import com.ftl.SpringBootPayments.model.UserBillingAddress;
import com.ftl.SpringBootPayments.repository.PaymentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/saveAll")
    public String saveAll() {
        paymentDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "savePayments";

    }

    @PutMapping("/save")
    public void save(@RequestBody Payment payment) {
        paymentDAO.save(payment);
    }

//    @GetMapping("/show")
//    public String selectAll() {
//        List<Payment> payments = paymentDAO.selectAll();
//        System.out.println();
//        for(Payment p : payments){
//            logger.info(p.toString());
//            System.out.println(p.toString());
//        }
//        return paymentDAO.selectAll().toString();
//
//    }

    @GetMapping ("/show")
    @ResponseBody
    public List<Payment> selectAll() {
        List<Payment> payments = paymentDAO.selectAll();
        for(Payment p : payments){
            logger.info("Select from DB : " + p.toString());
            System.out.println(p.toString());
        }
        return payments;

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
