package com.ftl.payments.model;

import java.time.LocalDateTime;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Payment {
    private long id;
    private long templateId;
    private String cardNumber;
    private double sum;
    private String status;
    private LocalDateTime creationDateTime;
    private LocalDateTime statusChangedDateTime;

}
