--liquibase formatted sql

--changeset novak:1
CREATE TABLE org_unit_type(
    id    int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(32) NOT NULL
);

CREATE TABLE organisation_unit(
    id                int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code              VARCHAR (16) UNIQUE NOT NULL,
    name              VARCHAR(64) NOT NULL,
    description       VARCHAR(512),
    active            BIT NOT NULL,
    org_unit_type_id  INT NOT NULL,
    parent_id         INT,
    CONSTRAINT org_unit_type_id_fk FOREIGN KEY (org_unit_type_id) REFERENCES org_unit_type(id),
    CONSTRAINT org_unit_parent_id_fk FOREIGN KEY (parent_id) REFERENCES organisation_unit(id)
);

CREATE TABLE city_type(
    id    int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(32) NOT NULL
);

CREATE TABLE city(
    id            int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code          VARCHAR (16) NOT NULL,
    name          VARCHAR(64) NOT NULL,
    active        BIT NOT NULL,
    city_type_id  INT NOT NULL,
    org_unit_id   INT NOT NULL,
    CONSTRAINT city_type_id_fk FOREIGN KEY (city_type_id) REFERENCES city_type(id),
    CONSTRAINT org_unit_id_fk FOREIGN KEY (org_unit_id) REFERENCES organisation_unit(id)
);

CREATE TABLE event(
    id          int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(128) NOT NULL,
    start       TIMESTAMP,
    end         TIMESTAMP,
    free_entry  VARCHAR(2) DEFAULT 'NE',
    city_id     INT NOT NULL,
    created     TIMESTAMP,
    created_by  VARCHAR(32),
    modified    TIMESTAMP,
    modified_by VARCHAR(32),
    CONSTRAINT event_city_id_fk FOREIGN KEY (city_id) REFERENCES city(id),
    CONSTRAINT event_free_entry_CK CHECK (free_entry IN ('DA', 'NE'))
);

CREATE TABLE user (
 id         int NOT NULL AUTO_INCREMENT PRIMARY KEY,
 username   VARCHAR(32) NOT NULL,
 password   VARCHAR(128) NOT NULL,
 first_name VARCHAR(32),
 last_name  VARCHAR(32),
 enabled    BIT NOT NULL,
 created    TIMESTAMP,
 modified   TIMESTAMP
);

CREATE TABLE role (
 id       int NOT NULL AUTO_INCREMENT PRIMARY KEY,
 name     VARCHAR(20) NOT NULL,
 created  TIMESTAMP NOT NULL,
 modified TIMESTAMP
);

CREATE TABLE user_role (
 user_id INT NOT NULL,
 role_id INT NOT NULL,
 PRIMARY KEY (user_id, role_id),
 CONSTRAINT user_role_user_id_fk FOREIGN KEY (user_id) REFERENCES user(id),
 CONSTRAINT user_role_role_id_fk FOREIGN KEY (role_id) REFERENCES role(id)
);

--rollback drop table org_unit_type;
--rollback drop table organisation_unit;
--rollback drop table city_type;
--rollback drop table city;
--rollback drop table event;
--rollback drop table user;
--rollback drop table role;
--rollback drop table user_role;