-- liquibase formatted sql
-- changeset emalygin:1
CREATE TABLE users
(
    user_id          BIGINT          PRIMARY KEY,
    user_email       VARCHAR         NOT NULL,
    user_firstName   VARCHAR         NOT NULL,
    user_lastName    VARCHAR         NOT NULL,
    user_phone       VARCHAR         NOT NULL,
    user_regDate     VARCHAR         NOT NULL,
    user_city        VARCHAR         NOT NULL,
    user_image       VARCHAR         NOT NULL
);




