package com.ftl.payments.controller;

import com.ftl.payments.model.Template;
import com.ftl.payments.repository.TemplateDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");

    private final TemplateDAO templateDAO;

    @Autowired
    public TemplateController(TemplateDAO templateDAO) {
        this.templateDAO = templateDAO;
    }

    @PutMapping("/saveAll")
    public void saveAll(@RequestBody List<Template> templates) {
        templateDAO.saveAll(templates);
    }

    @PutMapping("/save")
    public void save(@RequestBody Template template) {
        templateDAO.save(template);
    }

    @GetMapping("/show")
    @ResponseBody
    public List<Template> selectAll() {
        List<Template> templates = templateDAO.selectAll();
        for (Template t : templates) {
            logger.info("Select from DB : " + t.toString());
        }
        return templates;
    }
}
