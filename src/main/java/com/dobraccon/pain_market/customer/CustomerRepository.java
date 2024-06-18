package com.dobraccon.pain_market.customer;


import com.dobraccon.pain_market.product.ProductRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    private static final String sqlInsert = "INSERT INTO customers(email) VALUES(:email)";
    private static final String sqlGetById = "SELECT * FROM customers WHERE id = :customerId";
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

    public void deleteById(long customerId) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource("customerId", customerId));
    }

    public void deleteByEmail(String customerEmail) {
        jdbcTemplate.update(sqlDeleteByEmail,
                new MapSqlParameterSource().addValue("customerEmail", customerEmail));
    }
}
