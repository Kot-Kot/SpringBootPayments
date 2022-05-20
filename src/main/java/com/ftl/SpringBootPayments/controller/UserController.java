package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.User;
import com.ftl.SpringBootPayments.repository.UserDAO;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final UserDAO userDAO;

    private final ReadFromInitFileController readFromInitFileController;

    @Autowired
    public UserController(UserDAO userDAO, ReadFromInitFileController readFromInitFileController) {
        this.userDAO = userDAO;
        this.readFromInitFileController = readFromInitFileController;
    }

    @Transactional
    @RequestMapping("/save")
    public String saveAll() {
        userDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "saveUsers";
    }

    @GetMapping("/show")
    public String selectAll() {
        List<User> users = userDAO.selectAll();
        for(User u : users){
            logger.info(u.toString());
            System.out.println(u.toString());
        }
        return userDAO.selectAll().toString();

    }
//    @GetMapping("/hello")
//    public String helloPage (HttpServletRequest request) {
//        String name = request.getParameter("n");
//        String surname = request.getParameter("s");
//        System.out.println(name + " " + surname);
//        return "users/hello";
//    }



}
