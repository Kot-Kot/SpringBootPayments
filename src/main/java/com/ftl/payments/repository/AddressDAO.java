package com.ftl.payments.repository;


import com.ftl.payments.model.UserBillingAddress;
import com.ftl.payments.repository.mappers.AddressMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.sql.Types.VARCHAR;

@Repository
public class AddressDAO {
    private static final Logger logger = (Logger) LogManager.getLogger("LOG_TO_FILE");
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserBillingAddress> selectAll() {
        return jdbcTemplate.query("SELECT * FROM user_billing_addresses", new AddressMapper());
    }

    public void saveAll(List<UserBillingAddress> addresses) {
        for (UserBillingAddress address : addresses) {
            save(address);
        }
        logger.info("Save all addresses to DB");
    }

    public void save(UserBillingAddress address) {
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
