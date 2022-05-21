package com.ftl.payments.controller;

import com.ftl.payments.model.Payment;
import com.ftl.payments.repository.PaymentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final PaymentDAO paymentDAO;
    @Value("${paymentStatusNew}")
    private String status;

    @Autowired
    public PaymentController(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @GetMapping("/updateAll")
    public void updateAll() {
        paymentDAO.updateAllWithStatusNew("new");
    }

    @PutMapping("/save")
    public void save(@RequestBody Payment payment) {
        paymentDAO.save(payment);
    }

    @PutMapping("/saveAll")
    public void saveAll(@RequestBody List<Payment> payments) {
        paymentDAO.saveAll(payments);
    }

    @GetMapping("/show")
    @ResponseBody
    public List<Payment> selectAll() {
        List<Payment> payments = paymentDAO.selectAll();
        for (Payment p : payments) {
            logger.info("Select from DB : " + p.toString());
        }
        return payments;

    }

    @GetMapping("/showStatusNew")
    @ResponseBody
    public List<Payment> selectStatusNew() {
        List<Payment> payments = paymentDAO.selectWithStatus(status);
        for (Payment p : payments) {
            logger.info("Select from DB : " + p.toString());
        }
        return payments;

    }

}
