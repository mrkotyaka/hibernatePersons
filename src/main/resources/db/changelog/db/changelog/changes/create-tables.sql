--liquibase formatted sql
--changeset mrkotyaka:1
CREATE TABLE MAIN.PERSON (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
                                         surname VARCHAR(255) NOT NULL,
                                         phone_number VARCHAR(20),
                                         city_of_living VARCHAR(20),
                                         age INTEGER NOT NULL
);
--rollback DROP TABLE ORDERS;
--rollback DROP TABLE CUSTOMERS;