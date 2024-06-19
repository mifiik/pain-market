package com.dobraccon.pain_market.customer;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    private static final String sqlInsert = "INSERT INTO customers(email) VALUES(:email)";
    private static final String sqlGetById = "SELECT * FROM customers WHERE id = :customerId";
    private static final String sqlLoadByEmail = "SELECT * FROM customers WHERE email = :customerEmail";
    private static final String sqlDeleteById = "DELETE FROM customers WHERE id = :customerId";
    private static final String sqlDeleteByEmail = "DELETE FROM customers WHERE email = :customerEmail";

    public void create(Customer customer) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", customer.getEmail());

        jdbcTemplate.update(sqlInsert, params);
    }

    public Customer getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById,
                new MapSqlParameterSource().addValue("customerId", id),
                customerRowMapper);
    }

    public Customer loadByEmail(String customerEmail) {
        return jdbcTemplate.queryForObject(sqlLoadByEmail,
                new MapSqlParameterSource().addValue("customerEmail", customerEmail),
                customerRowMapper);
    }

    public void deleteById(long customerId) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource("customerId", customerId));
    }

    public void deleteByEmail(String customerEmail) {
        jdbcTemplate.update(sqlDeleteByEmail,
                new MapSqlParameterSource().addValue("customerEmail", customerEmail));
    }
}
