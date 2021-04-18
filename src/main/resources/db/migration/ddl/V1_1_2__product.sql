CREATE TABLE product
(
    id   INT primary key,
    code VARCHAR(255) not null,
    pointsCost decimal,
    status boolean NOT NULL DEFAULT FALSE
);