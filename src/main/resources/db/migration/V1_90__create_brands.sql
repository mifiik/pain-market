CREATE SEQUENCE brands_sequence;

CREATE TABLE brands
(
    id        BIGINT DEFAULT nextval('brands_sequence') NOT NULL PRIMARY KEY,
    image_url varchar(255)                              NOT NULL,
    name      varchar(125)                              NOT NULL
);

INSERT INTO brands(image_url, name)
VALUES ('example1.com/brand1.jpg', 'Nike'),
       ('example2.com/brand2.jpg', 'Etnilogy'),
       ('example3.com/brand3.jpg', 'Lenium'),
       ('example4.com/brand4.jpg', 'Adinol'),
       ('example5.com/brand5.jpg', 'Beadi'),
       ('example6.com/brand6.jpg', 'NUK'),
       ('example7.com/brand7.jpg', 'Nutrilon'),
       ('example8.com/brand8.jpg', 'Nilenium'),
       ('example9.com/brand9.jpg', 'Pukypu');
