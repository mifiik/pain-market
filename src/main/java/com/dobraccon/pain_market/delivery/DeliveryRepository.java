package com.dobraccon.pain_market.delivery;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeliveryRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DeliveryRowMapper deliveryRowMapper;

    private static final String sqlInsert = "INSERT INTO deliveries(order_id, customer_id, address)" +
            "VALUES(:order_id,:customer_id,:address)";

    private static final String sqlGetById = "SELECT * FROM deliveries WHERE id=:deliveryId";

    public void create(Delivery delivery) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("order_id", delivery.getOrderId());
        parameterSource.addValue("customer_id", delivery.getCustomerId());
        parameterSource.addValue("address", delivery.getAddress());

        jdbcTemplate.update(sqlInsert, parameterSource);
    }

    public Delivery getById(long id) {
        return jdbcTemplate.queryForObject(
                sqlGetById,
                new MapSqlParameterSource().addValue("deliveryId", id),
                deliveryRowMapper);
    }
}




