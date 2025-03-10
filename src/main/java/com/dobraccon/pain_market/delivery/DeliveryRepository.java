package com.dobraccon.pain_market.delivery;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DeliveryRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DeliveryRowMapper deliveryRowMapper;

    private static final String sqlInsert = "INSERT INTO deliveries(order_id, customer_id, address)" +
            "VALUES(:order_id,:customer_id,:address)";
    private static final String sqlGetById = "SELECT * FROM deliveries WHERE id=:deliveryId";
    private static final String sqlDeleteByAddress = "DELETE FROM deliveries WHERE address = :deliveryAddress";
    private static final String sqlDeleteByOrderIdAndCustomerId = "DELETE FROM deliveries WHERE order_id = :orderId " +
            "AND customer_id = :customerId";
    private static final String sqlDeleteByDeliveryId = "DELETE FROM deliveries WHERE id = :deliveryId";
    private static final String sqlGetByStatusId = "SELECT * FROM deliveries WHERE status_id =:statusId";

    public void create(Delivery delivery) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("order_id", delivery.getOrderId());
        parameterSource.addValue("customer_id", delivery.getCustomerId());
        parameterSource.addValue("status_id", delivery.getStatusId());
        parameterSource.addValue("address", delivery.getAddress());

        jdbcTemplate.update(sqlInsert, parameterSource);
    }

    public Delivery getById(long id) {
        return jdbcTemplate.queryForObject(
                sqlGetById,
                new MapSqlParameterSource().addValue("deliveryId", id),
                deliveryRowMapper);
    }

    public void deleteByDeliveryId(long deliveryId) {
        jdbcTemplate.update(sqlDeleteByDeliveryId,
                new MapSqlParameterSource().addValue("deliveryId", deliveryId));
    }

    public void deleteByAddress(String deliveryAddress) {
        jdbcTemplate.update(sqlDeleteByAddress,
                new MapSqlParameterSource().addValue("deliveryAddress", deliveryAddress));
    }

    public void deleteByOrderIdAndCustomerId(long orderId, long customerId) {
        jdbcTemplate.update(sqlDeleteByOrderIdAndCustomerId,
                new MapSqlParameterSource().addValue("orderId", orderId)
                        .addValue("customerId", customerId));
    }

    public List<Delivery> getByStatusId(long statusId) {
        return jdbcTemplate.query(
                sqlGetByStatusId,
                new MapSqlParameterSource().addValue("statusId", statusId),
                deliveryRowMapper);
    }
}




