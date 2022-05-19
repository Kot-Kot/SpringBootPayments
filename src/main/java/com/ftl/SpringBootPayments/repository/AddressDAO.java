package com.ftl.SpringBootPayments.repository;


import com.ftl.SpringBootPayments.model.User;
import com.ftl.SpringBootPayments.model.UserBillingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class AddressDAO {
    private static final String KEYWORD = "ADDRESS";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<UserBillingAddress> mapper = BeanPropertyRowMapper.newInstance(UserBillingAddress.class);

    @Autowired
    public AddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserBillingAddress> selectAll() {
        return jdbcTemplate.query("SELECT * FROM user_billing_addresses", mapper);
    }

    public void saveAll(List<String> stringsFromFile) {
        String[] userBillingAddresses = null;
        for (String s : stringsFromFile) {
            System.out.println(s);
            if (s.contains(KEYWORD)) {
                userBillingAddresses = s.split("\\|");
                jdbcTemplate.update("INSERT INTO user_billing_addresses (billing_address, contact) VALUES (?, ?);",
                        userBillingAddresses[1], userBillingAddresses[2]);

            }


        }
    }

}
