package com.ftl.SpringBootPayments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserBillingAddress {
    private long id;
    private String billingAddress;
    private String userContact;

}
