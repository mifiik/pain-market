package com.dobraccon.pain_market.promotions;

import com.dobraccon.pain_market.product.Product;
import com.dobraccon.pain_market.product.ProductRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PromotionRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final PromotionRowMapper promotionRowMapper;
    private final ProductRowMapper productRowMapper;

    private static final String sqlInsertPromotion = "INSERT INTO promotions(image_url, promotion_name, " +
            "promotion_description," +
            " is_promotion_actual)" +
            "VALUES(:imageUrl, :promotionName, :promotionDescription, :isPromotionActual)";
    private static final String sqlGetById = "SELECT * FROM promotions WHERE id = :promotionsId";
    private static final String sqlDeleteById = "DELETE FROM promotions WHERE id = :promotionsId";
    private static final String sqlAddProductIdToPromotion = "INSERT INTO xref_promotions_2_products (promotion_id, " +
            "product_id) VALUES (:promotionId, :productId)";
    private static final String sqlGetAllPromotions = "SELECT * FROM promotions";
    private static final String sqlGetActualPromotions = "SELECT * FROM promotions WHERE is_promotion_actual = true";
    private static final String sqlGetProductsByPromotionId = "SELECT p.* FROM products p " +
            "JOIN xref_promotions_2_products x ON p.id = x.product_id " +
            "WHERE x.promotion_id = :promotionId";

    public void create(Promotion promotion) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("imageUrl", promotion.getImageUrl());
        parameterSource.addValue("promotionName", promotion.getPromotionName());
        parameterSource.addValue("promotionDescription", promotion.getPromotionDescription());
        parameterSource.addValue("isPromotionActual", promotion.isPromotionActual());

        jdbcTemplate.update(sqlInsertPromotion, parameterSource);
    }

    public Promotion getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById,
                new MapSqlParameterSource().addValue("promotionsId", id),
                promotionRowMapper);
    }

    public void deleteById(long promotionsId) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource("promotionsId", promotionsId));
    }

    public void addListOfProductsToPromotion(ProductsToPromotionInput productsToPromotionInput) {
        productsToPromotionInput.getProductsIds().forEach(productId -> {
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("promotionId", productsToPromotionInput.getPromotionId());
            parameterSource.addValue("productId", productId);
            jdbcTemplate.update(sqlAddProductIdToPromotion, parameterSource);
        });
    }

    public List<Promotion> getAllPromotions() {
        return jdbcTemplate.query(sqlGetAllPromotions, promotionRowMapper);
    }

    public List<Promotion> getActualPromotions() {
        return jdbcTemplate.query(sqlGetActualPromotions, promotionRowMapper);
    }

    public List<Product> getProductsByPromotionId(long promotionId) {
        return jdbcTemplate.query(sqlGetProductsByPromotionId,
                new MapSqlParameterSource("promotionId", promotionId),
                productRowMapper);
    }
}

