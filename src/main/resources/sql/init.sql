CREATE SEQUENCE products_sequence;

CREATE TABLE products
(
    id                BIGINT DEFAULT nextval('products_sequence')       NOT NULL PRIMARY KEY,
    primary_price     FLOAT CHECK (primary_price >= 0)                  NOT NULL,
    current_price     FLOAT CHECK (current_price >= 0)                  NOT NULL,
    discount          INTEGER CHECK (discount >= 0 AND discount <= 100) NOT NULL,
    is_new            BOOLEAN                                           NOT NULL,
    image_url         VARCHAR(255)                                      NOT NULL,
    description       VARCHAR(255)                                      NOT NULL,
    min_delivery_days INTEGER CHECK (min_delivery_days >= 0 )           NOT NULL,
    max_delivery_days INTEGER CHECK (max_delivery_days >= 0 )           NOT NULL,
    rating            FLOAT CHECK (rating >= 0 AND rating <= 5)         NOT NULL,
    review_count      INTEGER                                           NOT NULL
);

INSERT INTO products (primary_price, current_price, discount, is_new, image_url, description, min_delivery_days,
                      max_delivery_days, rating, review_count)
VALUES (10.0, 10.0, 10, true, 'example.com/product1.jpg', 'Description for Product 1', 3, 5, 4, 100),
       (20.0, 20.0, 20, true, 'example.com/product2.jpg', 'Description for Product 2', 2, 4, 5, 150),
       (30.0, 30.0, 15, false, 'example.com/product3.jpg', 'Description for Product 3', 1, 3, 3, 200),
       (40.0, 40.0, 5, false, 'example.com/product4.jpg', 'Description for Product 4', 5, 7, 4, 50),
       (50.0, 50.0, 0, true, 'example.com/product5.jpg', 'Description for Product 5', 3, 6, 5, 80);


CREATE SEQUENCE customers_sequence;

CREATE TABLE customers
(
    id           BIGINT DEFAULT nextval('customers_sequence') NOT NULL PRIMARY KEY,
    image_url    VARCHAR(255),
    legal_entity BOOLEAN                                      NOT NULL,
    email        VARCHAR(125)                                 NOT NULL,
    phone_number INTEGER CHECK (phone_number > 0)             NOT NULL,
    first_name   VARCHAR(125)                                 NOT NULL,
    last_name    VARCHAR(125)                                 NOT NULL,
    password     VARCHAR(125)                                 NOT NULL,
    city         VARCHAR(125)                                 NOT NULL,
    street       VARCHAR(125)                                 NOT NULL,
    city_index   VARCHAR(125)                                 NOT NULL
);

INSERT INTO customers (image_url, legal_entity, email, phone_number, first_name, last_name, password, city, street,
                       city_index)
VALUES ('example.com/image1.jpg', false, 'testEmail1@example.com', 1234567890, 'John', 'Doe', 'password123', 'New York',
        '123 Elm St', 10001),
       ('example.com/image2.jpg', false, 'testEmail2@example.com', 1234567891, 'Jane', 'Doe', 'password123',
        'Los Angeles', '456 Oak St', 90001),
       ('example.com/image3.jpg', true, 'testEmail3@example.com', 1234567892, 'Jim', 'Beam', 'password123', 'Chicago',
        '789 Pine St', 60601),
       ('example.com/image4.jpg', true, 'testEmail4@example.com', 1234567893, 'Jack', 'Daniels', 'password123',
        'Houston', '101 Maple St', 77001),
       ('example.com/image5.jpg', false, 'testEmail5@example.com', 1234567894, 'Johnny', 'Walker', 'password123',
        'Phoenix', '202 Birch St', 85001);

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

CREATE SEQUENCE deliveries_sequence;

CREATE TABLE deliveries
(
    id          BIGINT DEFAULT nextval('deliveries_sequence') NOT NULL PRIMARY KEY,
    order_id    BIGINT REFERENCES orders (id)                 NOT NULL,
    customer_id BIGINT REFERENCES customers (id)              NOT NULL,
    address     VARCHAR(255)                                  NOT NULL
);

INSERT INTO deliveries (order_id, customer_id, address)
VALUES (1, 1, 'address 1'),
       (2, 2, 'address 2'),
       (3, 3, 'address 3'),
       (4, 4, 'address 4'),
       (5, 5, 'address 5');
