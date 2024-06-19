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
                resultSet.getFloat("primary_price"),
                resultSet.getFloat("current_price"),
                resultSet.getInt("discount"),
                resultSet.getBoolean("is_new"),
                resultSet.getString("image_url"),
                resultSet.getString("description"),
                resultSet.getInt("min_delivery_days"),
                resultSet.getInt("max_delivery_days"),
                resultSet.getFloat("rating"),
                resultSet.getInt("review_count")
        );
    }
}
