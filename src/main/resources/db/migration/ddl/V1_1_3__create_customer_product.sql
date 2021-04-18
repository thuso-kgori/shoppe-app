CREATE TABLE customer_product
(
    fk_customer_id BIGINT NOT NULL ,
    fk_product_id BIGINT NOT NULL ,
    FOREIGN KEY (fk_customer_id) REFERENCES customer(id),
    FOREIGN KEY (fk_product_id) REFERENCES product(id),
    CONSTRAINT pk_customer__product PRIMARY KEY (fk_customer_id, fk_product_id)

);