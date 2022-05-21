package com.ftl.SpringBootPayments.repository;


import com.ftl.SpringBootPayments.model.Payment;
import com.ftl.SpringBootPayments.model.Template;
import com.ftl.SpringBootPayments.repository.mappers.PaymentMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

import static java.sql.Types.VARCHAR;
import static java.sql.Types.NUMERIC;
import static java.sql.Types.TIMESTAMP;
import static java.sql.Types.BIGINT;

@Log4j2
@Repository
public class PaymentDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private static final String KEYWORD = "PAYMENT";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Payment> mapper = BeanPropertyRowMapper.newInstance(Payment.class);
    @Autowired
    public PaymentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Payment> selectAll()
    {
        return jdbcTemplate.query("SELECT * FROM payments", new PaymentMapper());
    }

    public List<Payment> selectWithStatus(String status) {
        return jdbcTemplate.query("SELECT * FROM payments WHERE status = ?", new String[]{status}, new PaymentMapper());
    }

    public void update(String newStatus, Long id) {
        jdbcTemplate.update("UPDATE payments SET status = ?, status_changed_dt = ? WHERE id = ?",
                newStatus,Timestamp.valueOf(LocalDateTime.now()), id);
    }

    public void saveAll(List<String> stringsFromFile) {
        String[] payment = null;
        for (String s : stringsFromFile) {
            if (s.contains(KEYWORD)) {
                System.out.print("Added payment    ");
                System.out.println(s);
                payment = s.split("\\|");
                payment[4] = payment[4].replaceAll("[^A-Za-z0-9]", "");
                jdbcTemplate.update("INSERT INTO payments " +
                                "(template_id, card_number, p_sum, status, creation_dt, status_changed_dt) " +
                                "VALUES (?, ?, ?, ?, ?, ?);",
                        Long.parseLong(payment[1]), payment[2], Double.parseDouble(payment[3]), payment[4],  Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));

            }

        }
        logger.info("Save all payments to DB");
    }

    public void save (Payment payment) {
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
