package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.UserBillingAddress;
import com.ftl.SpringBootPayments.repository.AddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final AddressDAO addressDAO;

    @Autowired
    public AddressController(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }


    @PutMapping("/saveAll")
    public void saveAll(@RequestBody List<UserBillingAddress> addresses) {
        addressDAO.saveAll(addresses);
    }

    @PutMapping("/save")
    public void save(@RequestBody UserBillingAddress address) {
        addressDAO.save(address);
    }


    @GetMapping ("/show")
    @ResponseBody
    public List<UserBillingAddress> selectAll() {
        List<UserBillingAddress> userBillingAddresses = addressDAO.selectAll();
        for(UserBillingAddress u : userBillingAddresses){
            logger.info("Select from DB : " + u.toString());
        }
        return userBillingAddresses;
    }
}
