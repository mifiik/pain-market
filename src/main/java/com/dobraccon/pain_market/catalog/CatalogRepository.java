package com.dobraccon.pain_market.catalog;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CatalogRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final CatalogRowMapper catalogRowMapper;

    private static final String sqlCreate = "INSERT INTO catalogs(name) VALUES(:name)";
    private static final String sqlGetById = "SELECT * FROM catalogs WHERE id=:catalogId";
    private static final String sqlUpdate = "UPDATE catalogs SET name=:name WHERE id=:catalogId";
    private static final String sqlDeleteById = "DELETE FROM catalogs WHERE id=:catalogId";
    private static final String sqlGetAll = "SELECT * FROM catalogs";

    public void create(Catalog catalog) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", catalog.getId());
        parameterSource.addValue("name", catalog.getName());

        jdbcTemplate.update(sqlCreate, parameterSource);
    }

    public Catalog getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById,
                new MapSqlParameterSource()
                        .addValue("catalogId", id),
                catalogRowMapper);
    }

    public void update(Catalog catalog) {
        jdbcTemplate.update(sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("catalogId", catalog.getId())
                        .addValue("name", catalog.getName())
        );
    }

    public void deleteById(long id) {
        jdbcTemplate.update(sqlDeleteById,
                new MapSqlParameterSource("catalogId", id));
    }

    public List<Catalog> getAll() {
        return jdbcTemplate.query(sqlGetAll,
                new CatalogRowMapper());
    }
}
