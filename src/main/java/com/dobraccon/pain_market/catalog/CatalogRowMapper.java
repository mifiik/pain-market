package com.dobraccon.pain_market.catalog;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CatalogRowMapper implements RowMapper<Catalog> {
    public Catalog mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Catalog(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }
}
