package com.dobraccon.pain_market.order;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String sqlInsert = "INSERT INTO orders(product_id, client_id, price)\n" +
            "VALUES (:productId, :clientId, :price);";

    public void create(Order order) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("productId", order.getProductId());
        parameterSource.addValue("clientId", order.getClientId());
        parameterSource.addValue("price", order.getPrice());

        jdbcTemplate.update(sqlInsert, parameterSource);
    }
}
