package com.ftl.payments.repository.mappers;

import com.ftl.payments.model.UserBillingAddress;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<UserBillingAddress> {
    @Override
    public UserBillingAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserBillingAddress address = new UserBillingAddress();
        address.setId(rs.getLong("id"));
        address.setBillingAddress(rs.getString("billing_address"));
        address.setUserContact(rs.getString("contact"));
        return address;
    }
}
