package com.dobraccon.pain_market.categories;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoriesRowMapper implements RowMapper<Categories> {
    public Categories mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Categories(
                resultSet.getLong("id"),
                resultSet.getLong("categories_groups_id"),
                resultSet.getString("name")
        );
    }
}
