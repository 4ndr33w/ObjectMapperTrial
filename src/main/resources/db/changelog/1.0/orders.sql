--liquibase formatted sql
--changeset Andr33w:itk-project-mapper-004
--logicalFilePath:1.0/orders.sql

CREATE TABLE orders (
    id                  UUID            PRIMARY KEY DEFAULT uuid_generate_v4(),
    customer_id         UUID            NOT NULL,
    order_date          TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    shipping_address    TEXT            NOT NULL,
    total_price         DECIMAL(10,2)   NOT NULL,
    order_status        TEXT            NOT NULL DEFAULT 'CREATED',

    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

--rollback drop table orders;