CREATE SEQUENCE categories_groups_sequence;

CREATE TABLE categories_groups
(
    id         BIGINT DEFAULT nextval('categories_groups_sequence') NOT NULL PRIMARY KEY,
    catalog_id BIGINT REFERENCES catalogs (id)                      NOT NULL,
    name       VARCHAR(125)                                         NOT NULL
);

INSERT INTO categories_groups(catalog_id, name)
VALUES (1, 'Детские кроватки и манежи'),
       (2, 'Детские матрасы'),
       (3, 'Постельное белье и принадлежности');
