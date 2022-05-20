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
@Scope("prototype")
@Component
public class Template {
    private long templateID;
    private String templateName;
    private String iban;
    private String paymentPurpose;
    private String userContact;

//    @Autowired
//    public Template(long templateID, String templateName, String iban, String paymentPurpose, String userContact) {
//        this.templateID = templateID;
//        this.templateName = templateName;
//        this.iban = iban;
//        this.paymentPurpose = paymentPurpose;
//        this.userContact = userContact;
//    }
//
//    @Autowired
//    public Template() {
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Template template = (Template) o;
//        return Objects.equals(templateID, template.templateID) &&
//                Objects.equals(templateName, template.templateName) &&
//                Objects.equals(iban, template.iban) &&
//                Objects.equals(paymentPurpose, template.paymentPurpose) &&
//                Objects.equals(userContact, template.userContact);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(templateID, templateName, iban, paymentPurpose, userContact);
//    }
//
//    @Override
//    public String toString() {
//        return "Template{" +
//                "templateID=" + templateID +
//                ", templateName='" + templateName + '\'' +
//                ", iban='" + iban + '\'' +
//                ", paymentPurpose='" + paymentPurpose + '\'' +
//                ", userContact='" + userContact + '\'' +
//                '}';
//    }
//
//    public void setTemplateID(long templateID) {
//        this.templateID = templateID;
//    }
//
//    public void setTemplateName(String templateName) {
//        this.templateName = templateName;
//    }
//
//    public void setIban(String iban) {
//        this.iban = iban;
//    }
//
//    public void setPaymentPurpose(String paymentPurpose) {
//        this.paymentPurpose = paymentPurpose;
//    }
//
//    public void setUserContact(String userContact) {
//        this.userContact = userContact;
//    }
}
