package com.ftl.SpringBootPayments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Scope("prototype")
@Component
public class UserBillingAddress {
    private long id;
    private String billingAddress;
    private String userContact;

    @Autowired
    public UserBillingAddress(int userID, String billingAddress, String userContact) {
        this.id = userID;
        this.billingAddress = billingAddress;
        this.userContact = userContact;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserBillingAddress that = (UserBillingAddress) o;
//        return Objects.equals(id, that.id) &&
//                Objects.equals(billingAddress, that.billingAddress) &&
//                Objects.equals(userContact, that.userContact);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, billingAddress, userContact);
//    }
}
