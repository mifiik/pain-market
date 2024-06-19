package com.dobraccon.pain_market.order;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper;

    private static final String sqlInsert = "INSERT INTO orders(product_id, client_id, price)\n" + "VALUES " +
            "(:productId, :clientId, :price);";
    private static final String sqlGetById = "SELECT * FROM orders WHERE id = :orderId";
    private static final String sqlDeleteByPrice = "DELETE FROM orders WHERE price = :orderPrice";
    private static final String sqlDeleteByClientId = "DELETE FROM orders WHERE client_id = :clientId";
    private static final String sqlDeleteByOrderId = "DELETE FROM orders WHERE id = :orderId";
    private static final String sqlLoadByCustomerId = "SELECT * FROM orders WHERE client_id = :customerId";

    public void create(Order order) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("productId", order.getProductId());
        parameterSource.addValue("clientId", order.getClientId());
        parameterSource.addValue("price", order.getPrice());

        jdbcTemplate.update(sqlInsert, parameterSource);
    }

    public Order getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById, new MapSqlParameterSource().addValue("orderId", id),
                orderRowMapper);
    }

    public void deleteByOrderId(long orderId) {
        jdbcTemplate.update(sqlDeleteByOrderId,
                new MapSqlParameterSource().addValue("orderId", orderId));
    }

    public void deleteByPrice(float orderPrice) {
        jdbcTemplate.update(sqlDeleteByPrice, new MapSqlParameterSource().addValue("orderPrice", orderPrice));
    }

    public void deleteByClientId(long clientId) {
        jdbcTemplate.update(sqlDeleteByClientId,
                new MapSqlParameterSource().addValue("clientId", clientId));
    }

    public List<Order> getByCustomerId(long customerId) {
        return jdbcTemplate.query(sqlLoadByCustomerId,
                new MapSqlParameterSource("customerId", customerId),
                orderRowMapper);
    }
}
