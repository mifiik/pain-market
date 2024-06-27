CREATE SEQUENCE xref_products_2_categories_groups_sequence;

CREATE TABLE xref_products_2_categories_groups
(
    id                   BIGINT DEFAULT nextval('xref_products_2_categories_groups_sequence'),
    product_id           BIGINT REFERENCES products (id),
    categories_groups_id BIGINT REFERENCES categories_groups (id)
);
INSERT INTO xref_products_2_categories_groups (product_id, categories_groups_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);