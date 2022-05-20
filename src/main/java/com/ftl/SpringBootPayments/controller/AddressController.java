package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.UserBillingAddress;
import com.ftl.SpringBootPayments.repository.AddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final AddressDAO addressDAO;

    private final ReadFromInitFileController readFromInitFileController;

    @Autowired
    public AddressController(AddressDAO addressDAO, ReadFromInitFileController readFromInitFileController) {
        this.addressDAO = addressDAO;
        this.readFromInitFileController = readFromInitFileController;
    }


    @GetMapping("/save")
    public String saveAll() {
        addressDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "saveaddresses";

    }

    @GetMapping ("/show")
    public String selectAll() {
        List<UserBillingAddress> userBillingAddresses = addressDAO.selectAll();
        for(UserBillingAddress u : userBillingAddresses){
            logger.info(u.toString());
            System.out.println(u.toString());
        }
        return addressDAO.selectAll().toString();

    }
}
