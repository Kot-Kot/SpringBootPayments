//package com.ftl.SpringBootPayments.controller;
//
//
//import com.ftl.SpringBootPayments.ThreadReadPayments;
//import com.ftl.SpringBootPayments.repository.*;
//import com.ftl.SpringBootPayments.model.Payment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Controller;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//@Controller
//public class MainController {
//
//        long before = System.currentTimeMillis();
//        System.out.println("Main thread starts");
//        UserDAO userDAO = new UserDAO(jdbcTemplate);
//        TemplateDAO templateDAO = new TemplateDAO();
//        PaymentDAO paymentDAO = new PaymentDAO();
//        AddressDAO addressDAO = new AddressDAO();
//
//        ArrayList<Payment> paymentList = new ArrayList<>();
//        Payment payment = new Payment();
//        String[] userArr = null;
//        String[] billingAddressArr = null;
//        String[] templateArr = null;
//        String[] paymentArr = null;
//        Connection connection = connection();
//        String str = "";
//        ArrayList<String> stringsFromFile = new ArrayList<>();
//
//        new MainDAO().createTables(connection());
//
//
//        //LOG.log(Level.INFO, "Write to database");
//        ThreadReadPayments readPayments = new ThreadReadPayments("ThreadReadPayments", connection());
//        readPayments.start();
//        System.out.println("Payments thread starts");
//
//
//
//
//
//
//        try (FileReader reader = new FileReader("initdata.txt")) {
//            int c;
//            while ((c = reader.read()) != -1) {
//                if ((char) c == '\n') {
//                    //System.out.println(str);
//                    stringsFromFile.add(str);
//                    str = "";
//                    continue;
//                }
//                str += (char) c;
//            }
//            //LOG.log(Level.INFO, "Read from init file");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            //LOG.log(Level.SEVERE, "Exception:", e);
//        }
//
//        for (String s : stringsFromFile) {
//            System.out.println(s);
//            if (s.contains("REGISTRATION")) {
//                userArr = s.split("\\|");
//                userDAO.insert(connection, userArr);
//                continue;
//            }
//            if (s.contains("ADDRESS")) {
//                billingAddressArr = s.split("\\|");
//                addressDAO.insert(connection, billingAddressArr);
//                continue;
//            }
//            if (s.contains("TEMPLATE")) {
//                templateArr = s.split("\\|");
//                templateDAO.insert(connection, templateArr);
//                continue;
//            }
//            if (s.contains("PAYMENT")) {
//                System.out.println(s);
//                paymentArr = s.split("\\|");
//                for (String s1 : paymentArr) {
//                    System.out.println(s1);
//                }
//                paymentArr[4] = paymentArr[4].replaceAll("[^A-Za-z0-9]", "");
//                paymentDAO.insert(connection, paymentArr);
//            }
//
//        }
////        LOG.log(Level.INFO, "Write to database");
////        ThreadReadPayments readPayments = new ThreadReadPayments("ThreadReadPayments", connection());
////        readPayments.start();
//        try {
//            readPayments.join();
//            //LOG.log(Level.INFO, "Change payments status");
//            userDAO.readAll(connection);
//            addressDAO.readAll(connection);
//            templateDAO.readAll(connection);
//            paymentDAO.readAll(connection);
//            //LOG.log(Level.INFO, "Read from database");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        long after = System.currentTimeMillis();
//        System.out.println("Executing TIME = " + (after - before));
//
//    }
//
//
//}
//
//
