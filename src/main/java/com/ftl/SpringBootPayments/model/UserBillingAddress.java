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




//    @Autowired
//    public UserBillingAddress(int userID, String billingAddress, String userContact) {
//        this.id = userID;
//        this.billingAddress = billingAddress;
//        this.userContact = userContact;
//    }
//    @Autowired
//    public UserBillingAddress() {
//    }
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
//
//    @Override
//    public String toString() {
//        return "UserBillingAddress{" +
//                "id=" + id +
//                ", billingAddress='" + billingAddress + '\'' +
//                ", userContact='" + userContact + '\'' +
//                '}';
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setBillingAddress(String billingAddress) {
//        this.billingAddress = billingAddress;
//    }
//
//    public void setUserContact(String userContact) {
//        this.userContact = userContact;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getBillingAddress() {
//        return billingAddress;
//    }
//
//    public String getUserContact() {
//        return userContact;
//    }
}
