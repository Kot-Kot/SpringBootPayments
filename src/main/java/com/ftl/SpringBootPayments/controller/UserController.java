package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserDAO userDAO;

    private final ReadFromInitFileController readFromInitFileController;

    @Autowired
    public UserController(UserDAO userDAO, ReadFromInitFileController readFromInitFileController) {
        this.userDAO = userDAO;
        this.readFromInitFileController = readFromInitFileController;
    }


    @RequestMapping("/save")
    public String saveAll() {
        userDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "saveusers";

    }

    @RequestMapping("/show")
    public String selectAll() {
        return userDAO.selectAll().toString();

    }
    @GetMapping("/hello")
    public String helloPage (HttpServletRequest request) {
        String name = request.getParameter("n");
        String surname = request.getParameter("s");
        System.out.println(name + " " + surname);
        return "users/hello";
    }


    @RequestMapping("/all")
    public void all() {
        saveAll();
        selectAll();
    }


}
