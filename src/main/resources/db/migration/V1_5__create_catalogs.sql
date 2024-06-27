CREATE SEQUENCE catalogs_sequence;

CREATE TABLE catalogs
(
    id   BIGINT DEFAULT nextval('catalogs_sequence') NOT NULL PRIMARY KEY,
    name VARCHAR(125)                                NOT NULL
);

INSERT INTO catalogs(name)
VALUES ('детская комната'),
       ('Игрушки и игры'),
       ('Товары для мамочек'),
       ('Гигиена и уход'),
       ('Детские подарки'),
       ('Елки и игрушки');
