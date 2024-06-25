package com.dobraccon.pain_market.delivery;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DeliveryRowMapper implements RowMapper<Delivery> {
    public Delivery mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Delivery(
                resultSet.getLong("id"),
                resultSet.getLong("order_id"),
                resultSet.getLong("customer_id"),
                resultSet.getLong("status_id"),
                resultSet.getString("address")
        );
    }
}
