package com.ftl.payments.controller;

import com.ftl.payments.model.User;
import com.ftl.payments.repository.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/show")
    @ResponseBody
    public List<User> selectAll() {
        List<User> users = userDAO.selectAll();
        for (User u : users) {
            logger.info("Select from DB : " + u.toString());
        }
        return users;
    }
}
