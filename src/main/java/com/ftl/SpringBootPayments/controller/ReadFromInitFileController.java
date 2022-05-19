package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.repository.ReadFromInitFileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class ReadFromInitFileController {
    private final ReadFromInitFileDAO readFromInitFileDAO;

    @Autowired
    public ReadFromInitFileController(ReadFromInitFileDAO readFromInitFileDAO) {
        this.readFromInitFileDAO = readFromInitFileDAO;
    }


    @GetMapping(value = "/read")
    public List<String> readFromInitFile() {
        return readFromInitFileDAO.readFromInitFile();
    }
}
