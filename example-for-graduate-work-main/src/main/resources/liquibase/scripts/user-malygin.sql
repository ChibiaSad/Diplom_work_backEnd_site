-- liquibase formatted sql
-- changeset alikeli:1
CREATE TABLE users
(
    user_id         INT PRIMARY KEY,
    user_email      VARCHAR NOT NULL,
    user_first_name VARCHAR NOT NULL,
    user_last_name  VARCHAR NOT NULL,
    user_phone      VARCHAR NOT NULL,
    user_reg_date   VARCHAR NOT NULL,
    user_city       VARCHAR NOT NULL,
    user_image      int8 NOT NULL
);

CREATE TABLE ads
(
    ads_id        int4 PRIMARY KEY,
    ads_author_id INT REFERENCES users (user_id),
    ads_image     VARCHAR NOT NULL,
    ads_price     int4    NOT NULL,
    ads_title     VARCHAR NOT NULL

);

CREATE TABLE comment
(
    comment_id         int4 PRIMARY KEY,
    comment_author_id  int4    NOT NULL,
    comment_created_at VARCHAR NOT NULL,
    comment_text       VARCHAR NOT NULL,
    ads_id             int4 REFERENCES ads (ads_id)
);


CREATE TABLE avatar
(
    avatar_id   int8 PRIMARY KEY,
    avatar_path VARCHAR NOT NULL,
    user_id     INT REFERENCES users (user_id)

);

CREATE TABLE image
(
    image_id   int4 PRIMARY KEY,
    image_path VARCHAR NOT NULL,
    ads_id     int4 REFERENCES ads (ads_id)
);
