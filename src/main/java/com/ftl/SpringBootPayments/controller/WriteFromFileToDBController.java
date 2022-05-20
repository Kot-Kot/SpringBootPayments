package com.ftl.SpringBootPayments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WriteFromFileToDBController {
    @Autowired
    private CreateTablesController createTablesController;
    @Autowired
    private UserController userController;
    @Autowired
    private AddressController addressController;
    @Autowired
    private TemplateController templateController;
    @Autowired
    private PaymentController paymentController;


    @RequestMapping("/write")
    public void readFromDB(){
        createTablesController.createTables();
        userController.saveAll();
        addressController.saveAll();
        templateController.saveAll();
        paymentController.saveAll();


    }

}
