CREATE SEQUENCE categories_sequence;

CREATE TABLE categories
(
    id                   BIGINT DEFAULT nextval('categories_sequence') NOT NULL PRIMARY KEY,
    category_group_id BIGINT REFERENCES categories_groups (id)      NOT NULL,
    name                 VARCHAR(125)                                  NOT NULL
);

INSERT INTO categories(category_group_id, name)
VALUES (1, 'Бортики для кроваток'),
       (2, 'наволочки'),
       (3, 'Детское постельное белье для колыбелей');
