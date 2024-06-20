package com.dobraccon.pain_market.customer;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {
    public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Customer(
                resultSet.getLong("id"),
                resultSet.getString("image_url"),
                resultSet.getBoolean("law_entity"),
                resultSet.getString("email"),
                resultSet.getInt("phone_number"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("password"),
                resultSet.getString("city"),
                resultSet.getString("street"),
                resultSet.getInt("city_index")
        );
    }
}
