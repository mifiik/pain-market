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

    private static final String sqlCreate = "INSERT INTO categories(categories_groups_id, name) " +
            "VALUES(:categoriesGroupsId, :name)";
    private static final String sqlGetById = "SELECT * FROM categories WHERE id=:categoriesId";
    private static final String sqlUpdate = "UPDATE categories SET categories_groups_id=:categoriesGroupsId, " +
            "name=:name WHERE " +
            "id=:categoriesId";
    private static final String sqlDeleteById = "DELETE FROM categories WHERE id=:categoriesId";
    private static final String sqlGetByGroupId = "SELECT * FROM categories WHERE " +
            "categories_groups_id=:categoriesGroupsId";
    private static final String sqlGetByCatalogId = "SELECT c.*\n" +
            "FROM categories c\n" +
            "         JOIN categories_groups cg ON c.categories_groups_id = cg.id\n" +
            "         JOIN catalogs ct ON cg.catalog_id = ct.id\n" +
            "WHERE c.id = :catalogId";

    public void create(Categories categories) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", categories.getId());
        parameterSource.addValue("categoriesGroupsId", categories.getCategoriesGroupsId());
        parameterSource.addValue("name", categories.getName());

        jdbcTemplate.update(sqlCreate, parameterSource);
    }

    public Categories getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById,
                new MapSqlParameterSource()
                        .addValue("categoriesId", id),
                categoriesRowMapper);
    }

    public void update(Categories categories) {
        jdbcTemplate.update(sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("categoriesId", categories.getId())
                        .addValue("categoriesGroupsId", categories.getCategoriesGroupsId())
                        .addValue("name", categories.getName())
        );
    }

    public void deleteById(long id) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource("categoriesId", id));
    }

    public List<Categories> getByGroupId(long categoriesGroupsId) {
        return jdbcTemplate.query(sqlGetByGroupId,
                new MapSqlParameterSource("categoriesGroupsId", categoriesGroupsId),
                new CategoriesRowMapper());
    }

    public List<Categories> getByCatalogId(long catalogId) {
        return jdbcTemplate.query(sqlGetByCatalogId,
                new MapSqlParameterSource().addValue("catalogId", catalogId),
                new CategoriesRowMapper());
    }
}
