package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Template;
import com.ftl.SpringBootPayments.model.UserBillingAddress;
import com.ftl.SpringBootPayments.repository.TemplateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {
    private final TemplateDAO templateDAO;

    private final ReadFromInitFileController readFromInitFileController;

    @Autowired
    public TemplateController(TemplateDAO templateDAO, ReadFromInitFileController readFromInitFileController) {
        this.templateDAO = templateDAO;
        this.readFromInitFileController = readFromInitFileController;
    }


    @RequestMapping("/save")
    public String saveAll() {
        templateDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "savetemplate";

    }

    @RequestMapping("/show")
    public String selectAll() {
        List<Template> templates = templateDAO.selectAll();
//        for(Template t : templates){
//            System.out.println(t.toString());
//        }
        return templateDAO.selectAll().toString();

    }
}
