package com.ftl.SpringBootPayments.repository;


import com.ftl.SpringBootPayments.model.Template;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private static final String KEYWORD = "TEMPLATE";
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Template> mapper = BeanPropertyRowMapper.newInstance(Template.class);

    @Autowired
    public TemplateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Template> selectAll() {
        return jdbcTemplate.query("SELECT * FROM templates", new TemplateMapper());
    }

    public void saveAll(List<String> stringsFromFile) {
        String[] template = null;
        for (String s : stringsFromFile) {
            if (s.contains(KEYWORD)) {
                System.out.print("Added template   ");
                System.out.println(s);
                template = s.split("\\|");
                template[4] = template[4].replaceAll("[^A-Za-z0-9]", "");
                jdbcTemplate.update("INSERT INTO templates (template_name, iban, purpose, contact) VALUES (?, ?, ?, ?);",
                        template[1], template[2], template[3], template[4]);

            }


        }
        logger.info("Save all templates to DB");
    }
}
