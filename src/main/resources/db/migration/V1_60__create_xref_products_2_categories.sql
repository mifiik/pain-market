CREATE SEQUENCE xref_products_2_categories_sequence;

CREATE TABLE xref_products_2_categories
(
    id            BIGINT DEFAULT nextval('xref_products_2_categories_sequence') NOT NULL PRIMARY KEY,
    products_id   BIGINT REFERENCES products (id),
    categories_id BIGINT REFERENCES categories (id)
);

INSERT INTO xref_products_2_categories(products_id, categories_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);
