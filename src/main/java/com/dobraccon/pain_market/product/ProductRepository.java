package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper;

    private static final String sqlInsert = "INSERT INTO products(name,price,discount)VALUES(:name,:price,:discount)";
    private static final String sqlGetById = "SELECT * FROM products WHERE id = :productId";
    private static final String sqlDeleteByName = "DELETE FROM products WHERE name = :productName";
    private static final String sqlDeleteByDiscount = "DELETE FROM products WHERE discount = :productDiscount";
    private static final String sqlDeleteById = "DELETE FROM products WHERE id = :productId";

    public void create(Product product) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", product.getName());
        params.addValue("price", product.getPrice());
        params.addValue("discount", product.getDiscount());

        jdbcTemplate.update(sqlInsert, params);
    }

    public Product getById(long id) {
        return jdbcTemplate.queryForObject(
                sqlGetById,
                new MapSqlParameterSource().addValue("productId", id),
                productRowMapper);
    }

    public void deleteById(long productId) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource().addValue("productId", productId));
    }

    public void deleteByName(String productName) {
        jdbcTemplate.update(sqlDeleteByName,
                new MapSqlParameterSource().addValue("productName", productName));
    }

    public void deleteByDiscount(int productDiscount) {
        jdbcTemplate.update(sqlDeleteByDiscount,
                new MapSqlParameterSource().addValue("productDiscount", productDiscount));
    }
}
