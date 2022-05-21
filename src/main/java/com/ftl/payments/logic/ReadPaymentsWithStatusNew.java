package com.ftl.payments.logic;

import com.ftl.payments.model.Payment;
import com.ftl.payments.repository.PaymentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

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
        List<Payment> payments = paymentDAO.selectWithStatus(status);
        if (CollectionUtils.isEmpty(payments)) {
            return;
        }
        for (Payment p : payments) {
            if (p.getCreationDateTime().until(LocalDateTime.now(), ChronoUnit.MILLIS) > 2000) {
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
