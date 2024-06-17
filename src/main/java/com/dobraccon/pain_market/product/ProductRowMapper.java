package com.dobraccon.pain_market.product;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Product(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getFloat("price"),
                resultSet.getInt("discount")
        );
    }
}
