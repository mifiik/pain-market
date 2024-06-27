CREATE SEQUENCE xref_products_2_catalogs_sequence;

CREATE TABLE xref_products_2_catalogs
(
    id         BIGINT DEFAULT nextval('xref_products_2_catalogs_sequence') NOT NULL PRIMARY KEY,
    product_id BIGINT REFERENCES products (id)                             NOT NULL,
    catalog_id BIGINT REFERENCES catalogs (id)                             NOT NULL
);

INSERT INTO xref_products_2_catalogs(product_id, catalog_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);