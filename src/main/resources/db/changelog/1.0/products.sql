--liquibase formatted sql
--changeset Andr33w:itk-project-mapper-003
--logicalFilePath:1.0/products.sql

CREATE TABLE products (
    id                  UUID            PRIMARY KEY DEFAULT uuid_generate_v4(),
    name                TEXT            NOT NULL,
    description         TEXT,
    price               DECIMAL(10,2)   NOT NULL,
    quantity_in_stock   BIGINT          NOT NULL DEFAULT 0
);

--rollback drop table products;