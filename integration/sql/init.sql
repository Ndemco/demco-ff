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
VALUES(1, 'Nick', 'DeMarco', 'ndemco', 'ndemco@gmail.com', '$2a$12$MfS1lvWiijLm0poA0RQp7.woq1eVcrUJH6BdDyIoSdYkHoqR.lNXO');