package com.ftl.SpringBootPayments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Scope("prototype")
@Component
public class Payment {
    private long id;
    private long templateId;
    private String cardNumber;
    private double sum;
    private String status;
    private LocalDateTime creationDateTime;
    private LocalDateTime statusChangedDateTime;

    @Autowired
    public Payment() {

    }
   @Autowired
    public Payment(long id, long templateId, String cardNumber, double sum, String status, LocalDateTime creationDateTime, LocalDateTime statusChangedDateTime) {
        this.id = id;
        this.templateId = templateId;
        this.cardNumber = cardNumber;
        this.sum = sum;
        this.status = status;
        this.creationDateTime = creationDateTime;
        this.statusChangedDateTime = statusChangedDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                Double.compare(payment.sum, sum) == 0 &&
                Objects.equals(templateId, payment.templateId) &&
                Objects.equals(cardNumber, payment.cardNumber) &&
                Objects.equals(creationDateTime, payment.creationDateTime) &&
                Objects.equals(statusChangedDateTime, payment.statusChangedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, templateId, cardNumber, sum, creationDateTime, statusChangedDateTime);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", templateId=" + templateId +
                ", cardNumber='" + cardNumber + '\'' +
                ", sum=" + sum +
                ", status='" + status + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", statusChangedDateTime=" + statusChangedDateTime +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getStatusChangedDateTime() {
        return statusChangedDateTime;
    }

    public void setStatusChangedDateTime(LocalDateTime statusChangedDateTime) {
        this.statusChangedDateTime = statusChangedDateTime;
    }
}
