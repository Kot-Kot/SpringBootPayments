package com.ftl.SpringBootPayments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

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
