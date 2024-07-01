package com.dobraccon.pain_market.categoriesGroups;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoriesGroupsRowMapper implements RowMapper<CategoriesGroups> {
    public CategoriesGroups mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new CategoriesGroups(
                resultSet.getLong("id"),
                resultSet.getLong("catalog_id"),
                resultSet.getString("name")
        );
    }
}
