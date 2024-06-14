package com.dobraccon.pain_market.customer;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String sqlInsert = "INSERT INTO customers(email) VALUES(:email)";


    public void create(Customer customer) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", customer.getEmail());

        jdbcTemplate.update(sqlInsert, params);
    }
}
