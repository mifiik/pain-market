package com.dobraccon.pain_market.brand;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class Brandrepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final BrandRowMapper brandRowMapper;

    private final static String sqlCreate = "INSERT INTO brands(image_url, name) VALUES(:imageUrl, :name)";
    private final static String sqlGetById = "SELECT * FROM brands WHERE id =:id";
    private final static String sqlDeleteById = "DELETE FROM brands WHERE id =:brandId";
    private final static String sqlUpdate = "UPDATE brands SET image_url =:imageUrl, name =:name";
    private final static String sqlGetByNameLike = "SELECT * FROM brands WHERE LOWER(name) LIKE LOWER(:name)";


    public void create(Brand brand) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("imageUrl", brand.getImageUrl());
        parameterSource.addValue("name", brand.getName());

        jdbcTemplate.update(sqlCreate, parameterSource);
    }

    public Brand getById(long id) {
        return jdbcTemplate.queryForObject(sqlGetById,
                new MapSqlParameterSource().addValue("id", id),
                brandRowMapper);
    }


    public void deleteById(long id) {
        jdbcTemplate.update(sqlDeleteById, new MapSqlParameterSource().addValue("brandId", id));
    }

    public void update(Brand brand) {
        jdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource().addValue("brandId", brand.getId())
                        .addValue("imageUrl", brand.getImageUrl())
                        .addValue("name", brand.getName())
        );
    }

    public List<Brand> getByNameLike(String name) {
        return jdbcTemplate.query(sqlGetByNameLike,
                new MapSqlParameterSource("name", name),
                brandRowMapper);
    }
}
