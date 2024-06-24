CREATE TABLE xref_promotions_2_products
(
    id           BIGSERIAL                         NOT NULL PRIMARY KEY,
    promotion_id BIGINT REFERENCES promotions (id) NOT NULL,
    product_id   BIGINT REFERENCES products (id)   NOT NULL
);

INSERT INTO xref_promotions_2_products (promotion_id, product_id)
VALUES (1, 1),
       (1, 2),
       (1, 4),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 5),
       (4, 3),
       (4, 5),
       (5, 4),
       (5, 5);
