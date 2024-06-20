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

    private static final String sqlInsert = "INSERT INTO products (primary_price, current_price, discount, is_new, " +
            "image_url, description, min_delivery_days, max_delivery_days, rating, review_count) " +
            "VALUES (:primaryPrice, :currentPrice, :discount, :isNew, :imageURL, :description, :minDeliveryDays, " +
            ":maxDeliveryDays, :rating, :reviewCount)";
    private static final String sqlGetById = "SELECT * FROM products WHERE id = :productId";
    private static final String sqlDeleteByDiscount = "DELETE FROM products WHERE discount = :productDiscount";
    private static final String sqlDeleteById = "DELETE FROM products WHERE id = :productId";

    public void create(Product product) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("primaryPrice", product.getPrimaryPrice());
        params.addValue("currentPrice", product.getCurrentPrice());
        params.addValue("discount", product.getDiscount());
        params.addValue("isNew", product.isNew());
        params.addValue("imageURL", product.getImageURL());
        params.addValue("description", product.getDescription());
        params.addValue("minDeliveryDays", product.getMinDeliveryDays());
        params.addValue("maxDeliveryDays", product.getMaxDeliveryDays());
        params.addValue("rating", product.getRating());
        params.addValue("reviewCount", product.getReviewCount());

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

    public void deleteByDiscount(int productDiscount) {
        jdbcTemplate.update(sqlDeleteByDiscount,
                new MapSqlParameterSource().addValue("productDiscount", productDiscount));
    }
}
