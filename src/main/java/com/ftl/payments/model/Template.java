package com.ftl.payments.model;

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
