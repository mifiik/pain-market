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