CREATE DATABASE demco_ff;

\c demco_ff;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id            SERIAL PRIMARY KEY,
  first_name    VARCHAR(50) NOT NULL,
  last_name     VARCHAR(50) NOT NULL,
  username      VARCHAR(50) NOT NULL,
  email         VARCHAR(250) UNIQUE NOT NULL
);

INSERT INTO users
(first_name, last_name, username, email)
VALUES
('Nick', 'DeMarco', 'Gabagool King', 'ndemco@gmail.com'),
('Christian', 'DeMarco', 'We Did It Joe', 'cdemco@gmail.com');