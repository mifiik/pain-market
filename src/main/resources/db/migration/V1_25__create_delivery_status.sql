CREATE SEQUENCE delivery_status_sequence;

CREATE TABLE delivery_status
(
    id          BIGINT DEFAULT nextval('delivery_status_sequence') NOT NULL PRIMARY KEY,
    status_name VARCHAR(125)                                       NOT NULL
);

INSERT INTO delivery_status(status_name)
VALUES ('CREATED'),
       ('DELIVERY'),
       ('COMPLETED');