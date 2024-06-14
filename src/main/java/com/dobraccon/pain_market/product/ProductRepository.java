package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String sqlInsert = "INSERT INTO products(name,price,discount)VALUES(:name,:price,:discount)";

    public void create(Product product) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", product.getName());
        params.addValue("price", product.getPrice());
        params.addValue("discount", product.getDiscount());

        jdbcTemplate.update(sqlInsert, params);

    }
}
