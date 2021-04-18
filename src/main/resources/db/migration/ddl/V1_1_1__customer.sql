CREATE TABLE customer
(
  id   INT primary key,
  name VARCHAR(255) not null,
  surname VARCHAR(255) not null,
  idNumber VARCHAR(255),
  points decimal,
  status boolean NOT NULL DEFAULT FALSE
);