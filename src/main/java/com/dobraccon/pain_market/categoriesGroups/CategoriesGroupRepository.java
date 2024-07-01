package com.dobraccon.pain_market.categoriesGroups;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CategoriesGroupRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final CategoriesGroupsRowMapper categoriesGroupsRowMapper;

    private static final String sqlCreate = "INSERT INTO categories_groups(catalog_id, name) VALUES(:catalogId,:name)";
    private static final String sqlGetById = "SELECT * FROM categories_groups WHERE id=:categoryGroupId";
    private static final String sqlUpdate = "UPDATE categories_groups SET catalog_id=:catalogId, name=:name WHERE " +
            "id=:categoryGroupId";
    private static final String sqlDeleteById = "DELETE FROM categories_groups WHERE id=:categoryGroupId";
    private static final String sqlGetAllByCatalogId = "SELECT * FROM categories_groups WHERE catalog_id=:catalogId";

    public void create(CategoriesGroups categoriesGroups) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", categoriesGroups.getId());
        parameterSource.addValue("catalogId", categoriesGroups.getCatalogId());
        parameterSource.addValue("name", categoriesGroups.getName());

        jdbcTemplate.update(sqlCreate, parameterSource);
    }

    public CategoriesGroups getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById,
                new MapSqlParameterSource()
                        .addValue("categoryGroupId", id),
                categoriesGroupsRowMapper);
    }

    public void update(CategoriesGroups categoriesGroups) {
        jdbcTemplate.update(sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("categoryGroupId", categoriesGroups.getId())
                        .addValue("catalogId", categoriesGroups.getCatalogId())
                        .addValue("name", categoriesGroups.getName())
        );

    }

    public void deleteById(long id) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource("categoryGroupId", id));
    }

    public List<CategoriesGroups> getAllByCatalogId(long catalogId) {
        return jdbcTemplate.query(sqlGetAllByCatalogId,
                new MapSqlParameterSource("catalogId", catalogId),
                new CategoriesGroupsRowMapper());
    }
}
