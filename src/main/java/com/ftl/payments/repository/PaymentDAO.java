package com.ftl.payments.repository;


import com.ftl.payments.model.Payment;

import com.ftl.payments.repository.mappers.PaymentMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

import static java.sql.Types.VARCHAR;
import static java.sql.Types.NUMERIC;
import static java.sql.Types.TIMESTAMP;
import static java.sql.Types.BIGINT;


@Repository
public class PaymentDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Payment> selectAll() {
        return jdbcTemplate.query("SELECT * FROM payments", new PaymentMapper());
    }

    public List<Payment> selectWithStatus(String status) {
        return jdbcTemplate.query("SELECT * FROM payments WHERE status = ?", new Object[]{status}
                , new int[]{Types.VARCHAR}
                , new PaymentMapper());
    }

    public void update(String newStatus, Long id) {
        jdbcTemplate.update("UPDATE payments SET status = ?, status_changed_dt = ? WHERE id = ?",
                newStatus, Timestamp.valueOf(LocalDateTime.now()), id);
    }

    public void updateAllWithStatusNew(String newStatus) {
        jdbcTemplate.update("UPDATE payments SET status = ?, status_changed_dt = ?",
                newStatus, Timestamp.valueOf(LocalDateTime.now()));
    }

    public void saveAll(List<Payment> payments) {
        for (Payment payment : payments) {
            save(payment);
        }
        logger.info("Save all payments to DB");
    }

    public void save(Payment payment) {
        jdbcTemplate.update(
                "INSERT INTO payments " +
                        "(template_id, card_number, p_sum, status, creation_dt, status_changed_dt) " +
                        "VALUES (?, ?, ?, ?, ?, ?);",
                new Object[]{
                        payment.getTemplateId(),
                        payment.getCardNumber(),
                        payment.getSum(),
                        payment.getStatus(),
                        Timestamp.valueOf(LocalDateTime.now()),
                        Timestamp.valueOf(LocalDateTime.now())

                },
                new int[]{
                        BIGINT, VARCHAR, NUMERIC, VARCHAR, TIMESTAMP, TIMESTAMP
                }
        );

        logger.info("Save payment to DB : " + payment.toString());
    }
}
