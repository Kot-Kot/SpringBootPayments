package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.User;
import com.ftl.SpringBootPayments.repository.UserDAO;
import lombok.extern.log4j.Log4j2;
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

        return "saveusers";

    }

    @RequestMapping("/show")
    public String selectAll() {
        List<User> users = userDAO.selectAll();
        Iterator<User> userIterator = users.iterator();
        System.out.println();
        while(userIterator.hasNext()) {
            System.out.println(userIterator.next().toString());
        }

//        for(User u : users){
////            System.out.printf("User [fio : %s, email : %s, phone : %s]", u.getFio(), u.getEmail(), u.getPhone());
////            System.out.print(u.getFio());
////            System.out.print(u.getEmail());
////            System.out.print(u.getPhone());
//        }
        return userDAO.selectAll().toString();

    }
    @GetMapping("/hello")
    public String helloPage (HttpServletRequest request) {
        String name = request.getParameter("n");
        String surname = request.getParameter("s");
        System.out.println(name + " " + surname);
        return "users/hello";
    }



}
