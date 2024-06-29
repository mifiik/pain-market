package com.dobraccon.pain_market.product;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    private static final String sqlGetByCategoriesId = "SELECT p.*\n" +
            "FROM products p\n" +
            "         JOIN xref_products_2_categories pc ON p.id = pc.products_id\n" +
            "WHERE pc.categories_id = :categoriesId;";
    private static final String sqlGetByCategoryGroupId =
            "SELECT p.* " +
                    "FROM products p " +
                    "JOIN xref_products_2_categories_groups pcg ON p.id = pcg.product_id " +
                    "JOIN categories_groups cg ON pcg.categories_groups_id = cg.id " +
                    "WHERE cg.id = :groupId";
    private static final String sqlGetByCatalogId = "select p.*\n" +
            "FROM products p\n" +
            "         JOIN xref_products_2_catalogs xpc ON p.id = xpc.product_id\n" +
            "         JOIN catalogs c ON xpc.product_id = c.id\n" +
            "WHERE c.id = :catalogId";

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

    public List<Product> getByCategoriesId(long categoriesId) {
        return jdbcTemplate.query(sqlGetByCategoriesId,
                new MapSqlParameterSource().addValue("categoriesId", categoriesId),
                new ProductRowMapper());
    }

    public List<Product> getByCategoryGroupId(long groupId) {
        return jdbcTemplate.query(sqlGetByCategoryGroupId,
                new MapSqlParameterSource().addValue("groupId", groupId),
                new ProductRowMapper());
    }

    public List<Product> getByCatalogId(long catalogId) {
        return jdbcTemplate.query(sqlGetByCatalogId,
                new MapSqlParameterSource().addValue("catalogId", catalogId),
                new ProductRowMapper());
    }
}
