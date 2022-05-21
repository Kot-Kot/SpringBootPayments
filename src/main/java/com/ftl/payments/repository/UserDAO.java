package com.ftl.payments.repository;

import com.ftl.payments.model.User;

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
public class UserDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> mapper = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> selectAll() {

        return jdbcTemplate.query("SELECT * FROM users", mapper);
    }

    public void saveAll(List<User> users) {
        for (User user : users) {
            save(user);
        }
        logger.info("Save all users to DB");
    }

    public void save(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (fio, email, phone) VALUES (?, ?, ?)",
                new Object[]{
                        user.getFio(),
                        user.getEmail(),
                        user.getPhone()
                },
                new int[]{
                        VARCHAR, VARCHAR, VARCHAR
                }
        );
        logger.info("Save user to DB : " + user.toString());
    }
}
