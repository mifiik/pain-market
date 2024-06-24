CREATE SEQUENCE promotions_sequence;

CREATE TABLE promotions
(
    id                    BIGINT DEFAULT nextval('promotions_sequence') NOT NULL PRIMARY KEY,
    image_url             VARCHAR(255),
    promotion_name        VARCHAR(125)                                  NOT NULL,
    promotion_description VARCHAR(255)                                  NOT NULL,
    is_promotion_actual   BOOLEAN                                       NOT NULL
);

INSERT INTO promotions(image_url, promotion_name, promotion_description, is_promotion_actual)
VALUES ('example.com/images/promo1.jpg', 'Summer Sale', 'Get up to 50% off on summer collection', true),
       ('example.com/images/promo2.jpg', 'Winter Clearance', 'Clearance sale on winter apparel', false),
       ('example.com/images/promo3.jpg', 'New Year Offer', 'Special discounts for the new year', true),
       ('example.com/images/promo4.jpg', 'Spring Fest', 'Enjoy the best deals this spring', true),
       ('example.com/images/promo5.jpg', 'Black Friday', 'Exclusive Black Friday discounts', false);