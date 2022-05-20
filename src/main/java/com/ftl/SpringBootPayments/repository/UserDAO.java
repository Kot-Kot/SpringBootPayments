package com.ftl.SpringBootPayments.repository;


import com.ftl.SpringBootPayments.model.User;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Log4j2
@Repository
public class UserDAO  {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");

    private static final String KEYWORD = "REGISTRATION";
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> mapper = BeanPropertyRowMapper.newInstance(User.class);


    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<User> selectAll() {

        return jdbcTemplate.query("SELECT * FROM users", mapper);
    }

    public void saveAll(List<String> stringsFromFile) {
        String[] user = null;
        for (String s : stringsFromFile) {
            if (s.contains(KEYWORD)) {
                System.out.print("Added user   ");
                System.out.println(s);
                user = s.split("\\|");
                user[3] = user[3].replaceAll("[^A-Za-z0-9]", "");
                jdbcTemplate.update("INSERT INTO users (fio, email, phone) VALUES(?, ?, ?)",
                        user[1], user[2], user[3]);

            }


        }
        logger.info("Save all users to DB");
    }

}
