CREATE SEQUENCE orders_sequence;

CREATE TABLE orders
(
    id         BIGINT DEFAULT nextval('orders_sequence') NOT NULL PRIMARY KEY,
    product_id BIGINT REFERENCES products (id)           NOT NULL,
    client_id  BIGINT REFERENCES customers (id)          NOT NULL,
    price      FLOAT CHECK (price >= 0)                  NOT NULL
);

INSERT INTO orders (product_id, client_id, price)
VALUES (1, 1, 9.0),
       (2, 2, 18.0),
       (3, 3, 25.5),
       (4, 4, 38.0),
       (5, 5, 50.0);
