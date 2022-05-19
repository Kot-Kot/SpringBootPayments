package com.ftl.SpringBootPayments.repository;


import com.ftl.SpringBootPayments.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class UserDAO  {
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
            System.out.println(s);
            if (s.contains(KEYWORD)) {
                user = s.split("\\|");
                jdbcTemplate.update("INSERT INTO users (fio, email, phone) VALUES(?, ?, ?)",
                        user[1], user[2], user[3]);

            }


        }
    }

}
