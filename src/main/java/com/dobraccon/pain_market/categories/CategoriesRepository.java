package com.dobraccon.pain_market.categories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CategoriesRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final CategoriesRowMapper categoriesRowMapper;

    private static final String sqlCreate = "INSERT INTO categories(category_group_id, name) " +
            "VALUES(:categoryGroupId, :name)";
    private static final String sqlGetById = "SELECT * FROM categories WHERE id=:categoryId";
    private static final String sqlUpdate = "UPDATE categories SET category_group_id=:categoryGroupId, " +
            "name=:name WHERE id=:categoryId";
    private static final String sqlDeleteById = "DELETE FROM categories WHERE id=:categoryId";
    private static final String sqlGetByGroupId = "SELECT * FROM categories WHERE category_group_id = :categoryGroupId";
    private static final String sqlGetByCatalogId = "SELECT c.*\n" +
            "FROM categories c\n" +
            "JOIN categories_groups cg ON c.category_group_id = cg.id\n" +
            "JOIN catalogs ct ON cg.catalog_id = ct.id\n" +
            "WHERE ct.id = :catalogId;";

    public void create(Categories categories) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", categories.getId());
        parameterSource.addValue("categoryGroupId", categories.getCategoryGroupId());
        parameterSource.addValue("name", categories.getName());

        jdbcTemplate.update(sqlCreate, parameterSource);
    }

    public Categories getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById,
                new MapSqlParameterSource()
                        .addValue("categoryId", id),
                categoriesRowMapper);
    }

    public void update(Categories categories) {
        jdbcTemplate.update(sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("categoryId", categories.getId())
                        .addValue("categoryGroupId", categories.getCategoryGroupId())
                        .addValue("name", categories.getName())
        );
    }

    public void deleteById(long id) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource("categoryId", id));
    }

    public List<Categories> getByCategoryGroupId(long categoryGroupId) {
        return jdbcTemplate.query(sqlGetByGroupId,
                new MapSqlParameterSource("categoryGroupId", categoryGroupId),
                categoriesRowMapper);
    }

    public List<Categories> getByCatalogId(long catalogId) {
        return jdbcTemplate.query(sqlGetByCatalogId,
                new MapSqlParameterSource().addValue("catalogId", catalogId),
                categoriesRowMapper);
    }
}

