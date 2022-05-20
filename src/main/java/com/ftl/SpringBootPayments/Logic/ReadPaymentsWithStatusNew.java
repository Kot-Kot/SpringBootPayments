package com.ftl.SpringBootPayments.Logic;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.repository.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Component
public class ReadPaymentsWithStatusNew {
    @Autowired
    private final static String status = "new";

    @Autowired
    private PaymentDAO paymentDAO;


    //private Random random;
    //private boolean flag = true;

    @Autowired
    public ReadPaymentsWithStatusNew(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }
    @Autowired
    public void startReading() {
//        while (flag) {
            System.out.println("\nEvery 1 sec");
            List<Payment> payments = paymentDAO.selectWithStatus(status);
//            System.out.println("Payments is empty = " + payments.isEmpty());
//            if (payments.isEmpty()) {
//                break;
//            }
            System.out.println("payments.size()    =    " + payments.size());

            LocalDateTime now = LocalDateTime.now();
            for (Payment p : payments) {
                System.out.println("time = " + p.getCreationDateTime().until(now, ChronoUnit.MILLIS));
                if (p.getCreationDateTime().until(now, ChronoUnit.MILLIS) <= 2000) {
                    paymentDAO.update(status, p.getId());
                } else {
                    System.out.println("statusGenerator  : " + p.getId() + "  " + p.getStatus());
                    paymentDAO.update(statusGenerator(), p.getId());
                }
            }


        }
//    }
    @Scope("prototype")
    @Bean
    private String statusGenerator() {
        Random random = new Random();
        int number = random.nextInt(3);
        switch (number) {
            case 0:
                return "paid";
            case 1:
                return "failed";
            case 2:
                return "new";

        }
        return null;
    }
}
