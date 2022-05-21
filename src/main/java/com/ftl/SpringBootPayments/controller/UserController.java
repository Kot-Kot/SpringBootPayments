package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.Template;
import com.ftl.SpringBootPayments.model.User;
import com.ftl.SpringBootPayments.repository.UserDAO;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PutMapping("/save")
    public void save(@RequestBody User user) {
        userDAO.save(user);
    }

    @PutMapping("/saveAll")
    public void saveAll(@RequestBody List<User> users) {
        userDAO.saveAll(users);
    }

    @GetMapping ("/show")
    @ResponseBody
    public List<User> selectAll() {
        List<User> users = userDAO.selectAll();
        for(User u : users){
            logger.info("Select from DB : " + u.toString());
        }
        return users;

}

}
