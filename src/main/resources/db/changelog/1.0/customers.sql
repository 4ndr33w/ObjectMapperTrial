--liquibase formatted sql
--changeset Andr33w:itk-project-mapper-002
--logicalFilePath:1.0/customers.sql

CREATE TABLE customers (
    id              UUID            PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name      TEXT,
    last_name       TEXT,
    email           TEXT            NOT NULL UNIQUE,
    contact_number  TEXT            NOT NULL UNIQUE
);

--rollback drop table customers;