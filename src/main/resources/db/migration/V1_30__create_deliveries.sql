CREATE SEQUENCE deliveries_sequence;

CREATE TABLE deliveries
(
    id          BIGINT DEFAULT nextval('deliveries_sequence') NOT NULL PRIMARY KEY,
    order_id    BIGINT REFERENCES orders (id)                 NOT NULL,
    customer_id BIGINT REFERENCES customers (id)              NOT NULL,
    status_id   BIGINT REFERENCES delivery_status (id)        NOT NULL,
    address     VARCHAR(255)                                  NOT NULL
);

INSERT INTO deliveries (order_id, customer_id, status_id, address)
VALUES (1, 1, 1, 'address 1'),
       (2, 2, 2, 'address 2'),
       (3, 3, 3, 'address 3'),
       (4, 4, 2, 'address 4'),
       (5, 5, 1, 'address 5');
