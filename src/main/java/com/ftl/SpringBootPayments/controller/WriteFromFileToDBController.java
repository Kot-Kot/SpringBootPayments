//package com.ftl.SpringBootPayments.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("")
//public class WriteFromFileToDBController {
//    @Autowired
//    private CreateTablesController createTablesController;
//    @Autowired
//    private UserController userController;
//    @Autowired
//    private AddressController addressController;
//    @Autowired
//    private TemplateController templateController;
//    @Autowired
//    private PaymentController paymentController;
//
//
//
//    @GetMapping("/write")
//    public void readFromDB(){
//        createTablesController.createTables();
//        userController.saveAll();
//        addressController.saveAll();
//        templateController.saveAll();
//        paymentController.saveAll();
//
//
//    }
//
//}
