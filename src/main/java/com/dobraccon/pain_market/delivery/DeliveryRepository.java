package com.dobraccon.pain_market.delivery;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeliveryRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String sqlInsert = "INSERT INTO deliveries(order_id, customer_id, address)" +
            "VALUES(:order_id,:customer_id,:address)";

    public void create(Delivery delivery) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("order_id", delivery.getOrder_id());
        parameterSource.addValue("customer_id", delivery.getCustomer_id());
        parameterSource.addValue("address", delivery.getAddress());

        jdbcTemplate.update(sqlInsert, parameterSource);
    }
}




