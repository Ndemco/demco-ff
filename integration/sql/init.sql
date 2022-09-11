CREATE DATABASE demco_ff;

\c demco_ff;

DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id            SERIAL PRIMARY KEY,
  first_name    VARCHAR(50) NOT NULL,
  last_name     VARCHAR(50) NOT NULL,
  email         VARCHAR(250) UNIQUE NOT NULL
);

INSERT INTO person
(first_name, last_name, email)
VALUES
('Nick', 'DeMarco', 'ndemco@gmail.com'),
('Christian', 'DeMarco', 'cdemco@gmail.com');