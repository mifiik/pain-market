package com.dobraccon.pain_market.order;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Order(
                resultSet.getLong("id"),
                resultSet.getLong("product_id"),
                resultSet.getLong("client_id"),
                resultSet.getLong("price")
        );
    }
}
