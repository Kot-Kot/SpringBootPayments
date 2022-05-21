package com.ftl.SpringBootPayments.Logic;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.repository.PaymentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
@EnableScheduling
@EnableAsync
@Component
public class ReadPaymentsWithStatusNew {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");

    @Autowired
    @Value("${paymentStatusNew}")
    private String status;

    @Autowired
    private PaymentDAO paymentDAO;

    @Autowired
    public ReadPaymentsWithStatusNew(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }


    @Autowired
    @Async
    @Scheduled(fixedDelay = 1000)
    public void startReading() {
//            System.out.println("\nEvery 1 sec");
            List<Payment> payments = paymentDAO.selectWithStatus(status);
//            System.out.println("payments_New.size()    =    " + payments.size());
//            System.out.println("payments.size()    =    " + paymentDAO.selectAll().size());
            if(payments.size() == 0 & paymentDAO.selectAll().size() != 0){
                return;
            }
            LocalDateTime now = LocalDateTime.now();
            for (Payment p : payments) {
                //System.out.println("time = " + p.getCreationDateTime().until(now, ChronoUnit.MILLIS));
                if (p.getCreationDateTime().until(now, ChronoUnit.MILLIS) > 2000) {
                    //System.out.println("statusGenerator  : " + p.getId() + "  " + p.getStatus());
                    String statusGenerator = statusGenerator();
                    paymentDAO.update(statusGenerator, p.getId());
                    logger.info(p.toString() + " change status to : " + statusGenerator);
                }
            }
        }

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
