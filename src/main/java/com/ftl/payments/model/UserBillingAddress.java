package com.ftl.payments.model;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserBillingAddress {
    private long id;
    private String billingAddress;
    private String userContact;

}
