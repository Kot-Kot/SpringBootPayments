package com.ftl.SpringBootPayments.repository;

import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.Template;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PaymentMapper implements RowMapper<Payment> {
    @Override
    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Payment payment = new Payment();
        payment.setId(rs.getLong("id"));
        payment.setTemplateId(rs.getLong("template_id"));
        payment.setCardNumber(rs.getString("card_number"));
        payment.setSum(rs.getDouble("p_sum"));
        payment.setStatus(rs.getString("status"));
        payment.setCreationDateTime(rs.getTimestamp("creation_dt").toLocalDateTime());
        payment.setStatusChangedDateTime(rs.getTimestamp("status_changed_dt").toLocalDateTime());
        return payment;
    }
}
