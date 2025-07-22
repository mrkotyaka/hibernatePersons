--liquibase formatted sql
--changeset mrkotyaka:2
INSERT INTO MAIN.PERSON (name, surname, phone_number, city_of_living, age)
VALUES ('alexey', 'ivanov', '+7987654321', 'Moscow', 22),
       ('ivan', 'petrov', '+7987234521', 'Moscow', 33),
       ('alexey', 'sidorov', '+7124534321', 'Kazan', 44);

--rollback DELETE FROM ORDERS;
--rollback DELETE FROM CUSTOMERS;