package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.repository.CreateTablesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTablesController {
    private final CreateTablesDAO createTablesDAO;

    @Autowired
    public CreateTablesController(CreateTablesDAO createTablesDAO) {
        this.createTablesDAO = createTablesDAO;
    }
    @GetMapping(value = "/create")
    public String createTables() {
        return createTablesDAO.createTables();
    }
}
