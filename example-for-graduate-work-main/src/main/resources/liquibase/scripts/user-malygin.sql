-- liquibase formatted sql
-- changeset emalygin:1
CREATE TABLE users
(
    user_id          INT          PRIMARY KEY,
    user_email       VARCHAR         NOT NULL,
    user_first_name   VARCHAR         NOT NULL,
    user_last_name    VARCHAR         NOT NULL,
    user_phone       VARCHAR         NOT NULL,
    user_reg_date     VARCHAR         NOT NULL,
    user_city        VARCHAR         NOT NULL,
    user_image       VARCHAR         NOT NULL
);

CREATE TABLE ads
(
    ads_id          BIGINT          PRIMARY KEY,
    ads_author       int4         NOT NULL,
    ads_pk           int4         NOT NULL,
    ads_price        int4         NOT NULL,
    ads_title       VARCHAR         NOT NULL,
    ads_image       VARCHAR         NOT NULL
);

CREATE TABLE comment
(
    comment_id          BIGINT          PRIMARY KEY,
    comment_author       int4         NOT NULL,
    comment_pk           int4         NOT NULL,
    comment_created_at       VARCHAR         NOT NULL,
    comment_text       VARCHAR         NOT NULL
);
--changeset asafiulina:2


CREATE TABLE avatar
(
    id_avatar         BIGINT         PRIMARY KEY ,
    data               bytea            NOT NULL ,
    file_path        VARCHAR            NOT NULL ,
    file_size          BIGINT           NOT NULL,
    media_type          VARCHAR         NOT NULL
);

CREATE TABLE image
(
    id_image            BIGINT       PRIMARY KEY ,
    data                bytea       NOT NULL ,
    file_path        VARCHAR            NOT NULL ,
    file_size          BIGINT           NOT NULL,
    media_type          VARCHAR         NOT NULL,
    ads_id              BIGINT          REFERENCES ads(ads_id)
);

--changeset chibiaSad:3
ALTER TABLE avatar ADD COLUMN
    user_id   INT REFERENCES users(user_id);

ALTER TABLE ads ADD COLUMN
    user_id   INT REFERENCES users(user_id);

ALTER TABLE comment ADD COLUMN
    ads_id   BIGINT REFERENCES ads(ads_id);



