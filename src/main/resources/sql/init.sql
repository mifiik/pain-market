CREATE SEQUENCE products_sequence;

CREATE TABLE products
(
    id       BIGINT DEFAULT nextval('products_sequence') NOT NULL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    price    FLOAT CHECK (price > 0) NOT NULL,
    discount INTEGER CHECK (discount >= 0 AND discount <= 100) NOT NULL
);

INSERT INTO products (name, price, discount)
VALUES ('Product 1', 10.0, 10),
       ('Product 2', 20.0, 20),
       ('Product 3', 30.0, 15),
       ('Product 4', 40.0, 5),
       ('Product 5', 50.0, 0);

CREATE SEQUENCE customers_sequence;

CREATE TABLE customers
(
    id    BIGINT DEFAULT nextval('customers_sequence') NOT NULL PRIMARY KEY,
    email VARCHAR(125) NOT NULL
);

INSERT INTO customers (email)
VALUES ('testEmail1'),
       ('testEmail2'),
       ('testEmail3'),
       ('testEmail4'),
       ('testEmail5');

CREATE SEQUENCE orders_sequence;

CREATE TABLE orders
(
    id         BIGINT DEFAULT nextval('orders_sequence') NOT NULL PRIMARY KEY,
    product_id BIGINT REFERENCES products (id) NOT NULL,
    client_id  BIGINT REFERENCES customers (id) NOT NULL,
    price      FLOAT
);

INSERT INTO orders (product_id, client_id, price)
VALUES (1, 1, 9.0),
       (2, 2, 18.0),
       (3, 3, 25.5),
       (4, 4, 38.0),
       (5, 5, 50.0);

CREATE SEQUENCE deliveries_sequence;

CREATE TABLE deliveries
(
    id          BIGINT DEFAULT nextval('deliveries_sequence') NOT NULL PRIMARY KEY,
    order_id    BIGINT REFERENCES orders (id) NOT NULL,
    customer_id BIGINT REFERENCES customers (id) NOT NULL,
    address     VARCHAR(255)
);

INSERT INTO deliveries (order_id, customer_id, address)
VALUES (1, 1, 'address 1'),
       (2, 2, 'address 2'),
       (3, 3, 'address 3'),
       (4, 4, 'address 4'),
       (5, 5, 'address 5');
