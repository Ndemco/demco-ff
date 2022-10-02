CREATE DATABASE demco_ff;

\c demco_ff;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id            SERIAL PRIMARY KEY,
  first_name    VARCHAR(50) NOT NULL,
  last_name     VARCHAR(50) NOT NULL,
  username      VARCHAR(50) NOT NULL,
  email         VARCHAR(250) UNIQUE NOT NULL,
  password      VARCHAR(250) NOT NULL
);

INSERT INTO users
(first_name, last_name, username, email, password)
VALUES
('Nick', 'DeMarco', 'Gabagool King', 'ndemco@gmail.com', 'abc123abc123'),
('Christian', 'DeMarco', 'We Did It Joe', 'cdemco@gmail.com', '123abc123abc');