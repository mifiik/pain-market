package com.dobraccon.pain_market.brand;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BrandRowMapper implements RowMapper<Brand> {
    public Brand mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Brand(
                resultSet.getLong("id"),
                resultSet.getString("image_url"),
                resultSet.getString("name")
        );
    }
}
