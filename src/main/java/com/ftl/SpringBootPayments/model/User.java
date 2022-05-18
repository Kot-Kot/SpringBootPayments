package com.ftl.SpringBootPayments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Scope("prototype")
@Component
public class User {
    private String fio;
    private String email;
    private String phone;

    @Autowired
    public User(String fio, String email, String phone) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
    }

    @Autowired
    public User() {

    }

//    public String getFio() {
//        return fio;
//    }
//
//    public void setFio(String fio) {
//        this.fio = fio;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(fio, user.fio) &&
//                Objects.equals(email, user.email) &&
//                Objects.equals(phone, user.phone);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(fio, email, phone);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "fio='" + fio + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                '}';
//    }
}
