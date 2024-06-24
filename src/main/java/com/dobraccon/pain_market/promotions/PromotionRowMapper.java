package com.dobraccon.pain_market.promotions;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PromotionRowMapper implements RowMapper<Promotion> {
    public Promotion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Promotion(
                resultSet.getLong("id"),
                resultSet.getString("image_url"),
                resultSet.getString("promotion_name"),
                resultSet.getString("promotion_description"),
                resultSet.getBoolean("is_promotion_actual")
        );
    }
}
