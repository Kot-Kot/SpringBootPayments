package com.ftl.SpringBootPayments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Template {
    private long templateID;
    private String templateName;
    private String iban;
    private String paymentPurpose;
    private String userContact;

}
