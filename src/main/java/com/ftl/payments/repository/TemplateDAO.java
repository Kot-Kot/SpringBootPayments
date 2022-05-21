package com.ftl.payments.repository;

import com.ftl.payments.model.Template;
import com.ftl.payments.repository.mappers.TemplateMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.sql.Types.VARCHAR;

@Repository
public class TemplateDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Template> mapper = BeanPropertyRowMapper.newInstance(Template.class);

    @Autowired
    public TemplateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Template> selectAll() {
        return jdbcTemplate.query("SELECT * FROM templates", new TemplateMapper());
    }

    public void saveAll(List<Template> templates) {
        for (Template template : templates) {
            save(template);
        }

        logger.info("Save all templates to DB");
    }

    public void save(Template template) {
        jdbcTemplate.update(
                "INSERT INTO templates (template_name, iban, purpose, contact) VALUES (?, ?, ?, ?)",
                new Object[]{
                        template.getTemplateName(),
                        template.getIban(),
                        template.getPaymentPurpose(),
                        template.getUserContact()
                },
                new int[]{
                        VARCHAR, VARCHAR, VARCHAR, VARCHAR
                }
        );

        logger.info("Save template to DB : " + template.toString());
    }

}
