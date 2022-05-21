package com.ftl.SpringBootPayments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Lombok;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;


@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class User {
    private String fio;
    private String email;
    private String phone;
}
