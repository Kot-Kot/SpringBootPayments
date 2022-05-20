package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.repository.ReadFromInitFileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@Controller
public class ReadFromInitFileController {
    private final ReadFromInitFileDAO readFromInitFileDAO;

    @Autowired
    public ReadFromInitFileController(ReadFromInitFileDAO readFromInitFileDAO) {
        this.readFromInitFileDAO = readFromInitFileDAO;
    }


    //@GetMapping(value = "/read")
    public List<String> readFromInitFile() {
        System.out.println("Read from init file");
        return readFromInitFileDAO.readFromInitFile();
    }
}
