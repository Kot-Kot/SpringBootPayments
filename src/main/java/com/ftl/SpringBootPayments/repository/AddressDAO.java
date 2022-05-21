package com.ftl.SpringBootPayments.repository;


import com.ftl.SpringBootPayments.model.UserBillingAddress;
import com.ftl.SpringBootPayments.repository.mappers.AddressMapper;
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
public class AddressDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private static final String KEYWORD = "ADDRESS";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<UserBillingAddress> mapper = BeanPropertyRowMapper.newInstance(UserBillingAddress.class);

    @Autowired
    public AddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserBillingAddress> selectAll() {
        return jdbcTemplate.query("SELECT * FROM user_billing_addresses", new AddressMapper());
    }

    public void saveAll(List<String> stringsFromFile) {
        String[] userBillingAddresses = null;
        for (String s : stringsFromFile) {
            if (s.contains(KEYWORD)) {
                System.out.print("Added address   ");
                System.out.println(s);
                userBillingAddresses = s.split("\\|");
                userBillingAddresses[2] = userBillingAddresses[2].replaceAll("[^A-Za-z0-9]", "");
                jdbcTemplate.update("INSERT INTO user_billing_addresses (billing_address, contact) VALUES (?, ?);",
                        userBillingAddresses[1], userBillingAddresses[2]);

            }


        }
        logger.info("Save all addresses to DB");
    }

    public void save (UserBillingAddress address) {
        jdbcTemplate.update(
                "INSERT INTO user_billing_addresses (billing_address, contact) VALUES (?, ?)",
                new Object[]{
                        address.getBillingAddress(),
                        address.getUserContact()
                },
                new int[]{
                        VARCHAR, VARCHAR
                }
        );
        logger.info("Save address to DB : " + address.toString());
    }

}
