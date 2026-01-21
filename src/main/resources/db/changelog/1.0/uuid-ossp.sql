--liquibase formatted sql
--changeset Andr33w:itk-project-mapper-001
--logicalFilePath:1.0/uui-ossp.sql

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--rollback drop extension uuid-ossp;