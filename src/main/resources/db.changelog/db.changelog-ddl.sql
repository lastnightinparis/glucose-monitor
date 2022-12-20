--liquibase formatted sql

--changeset Kirill:createTableUser
--preconditions onFail:CONTINUE onError:CONTINUE
CREATE TABLE enduser
(
    user_id     UUID primary key,
    username    varchar(250) not null unique,
    password    varchar(250) not null,
    "user_role" varchar(250) not null
);

--changeset Kirill:createTableDiary
--preconditions onFail:CONTINUE onError:CONTINUE
CREATE TABLE diary
(
    diary_id UUID primary key,
    user_id  UUID not null,
    FOREIGN KEY (user_id) REFERENCES enduser (user_id)
);

CREATE TABLE meal
(
    meal_id  UUID primary key,
    datetime timestamp not null
);

CREATE TABLE diaryentry
(
    diaryentry_id UUID primary key,
    meal_id       UUID,
    diary_id      UUID      not null,
    glucose_level decimal   not null,
    datetime      timestamp not null,
    FOREIGN KEY (diary_id) REFERENCES diary (diary_id),
    FOREIGN KEY (meal_id) REFERENCES meal (meal_id)
);

CREATE TABLE product
(
    product_id   UUID primary key,
    product_name varchar(250) not null
);

CREATE TABLE meal_product
(
    meal_id    UUID not null,
    product_id UUID not null,
    PRIMARY KEY (meal_id, product_id),
    FOREIGN KEY (meal_id) REFERENCES meal (meal_id),
    FOREIGN KEY (product_id) REFERENCES product (product_id)
);