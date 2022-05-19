package com.ftl.SpringBootPayments.repository;

import com.ftl.SpringBootPayments.model.Template;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TemplateMapper implements RowMapper<Template> {
    @Override
    public Template mapRow(ResultSet rs, int rowNum) throws SQLException {
        Template template = new Template();
        template.setTemplateID(rs.getLong("id"));
        template.setTemplateName(rs.getString("template_name"));
        template.setIban(rs.getString("iban"));
        template.setPaymentPurpose(rs.getString("purpose"));
        template.setUserContact(rs.getString("contact"));
        return template;
    }
}
