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

    private static final String sqlInsert = "INSERT INTO customers(image_url, legal_entity, email, phone_number, " +
            "first_name, last_name, password, city, street, city_index) " +
            "VALUES(:imageUrl, :legalEntity, :email, :phoneNumber, :firstName, :lastName, :password, :city, " +
            ":street, :cityIndex)";
    private static final String sqlGetById = "SELECT * FROM customers WHERE id = :customerId";
    private static final String sqlLoadByEmail = "SELECT * FROM customers WHERE email = :customerEmail";
    private static final String sqlDeleteById = "DELETE FROM customers WHERE id = :customerId";
    private static final String sqlDeleteByEmail = "DELETE FROM customers WHERE email = :customerEmail";

    public void create(Customer customer) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("imageUrl", customer.getImageUrl());
        params.addValue("legalEntity", customer.isLegalEntity());
        params.addValue("email", customer.getEmail());
        params.addValue("phoneNumber", customer.getPhoneNumber());
        params.addValue("firstName", customer.getFirstName());
        params.addValue("lastName", customer.getLastName());
        params.addValue("password", customer.getPassword());
        params.addValue("city", customer.getCity());
        params.addValue("street", customer.getStreet());
        params.addValue("cityIndex", customer.getCityIndex());

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
