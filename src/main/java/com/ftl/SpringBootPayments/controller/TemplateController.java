package com.ftl.SpringBootPayments.controller;

import com.ftl.SpringBootPayments.model.Template;
import com.ftl.SpringBootPayments.model.UserBillingAddress;
import com.ftl.SpringBootPayments.repository.TemplateDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");

    private final TemplateDAO templateDAO;

    private final ReadFromInitFileController readFromInitFileController;

    @Autowired
    public TemplateController(TemplateDAO templateDAO, ReadFromInitFileController readFromInitFileController) {
        this.templateDAO = templateDAO;
        this.readFromInitFileController = readFromInitFileController;
    }


    @GetMapping("/save")
    public String saveAll() {
        templateDAO.saveAll(readFromInitFileController.readFromInitFile());
        return "saveTemplate";

    }

    @GetMapping ("/show")
    public String selectAll() {
        List<Template> templates = templateDAO.selectAll();
        for(Template t : templates){
            System.out.println(t.toString());
            logger.info(t.toString());
        }
        return templateDAO.selectAll().toString();

    }
}
