--liquibase formatted sql
--changeset Andr33w:itk-project-mapper-005
--logicalFilePath:1.0/order_products.sql

CREATE TABLE order_products (
    order_id        UUID    NOT NULL,
    product_id      UUID    NOT NULL,

    PRIMARY KEY (order_id, product_id),

    CONSTRAINT fk_order     FOREIGN KEY (order_id)      REFERENCES orders(id)       ON DELETE CASCADE,
    CONSTRAINT fk_product   FOREIGN KEY (product_id)    REFERENCES products(id)     ON DELETE CASCADE
);

--rollback drop table order_products;