CREATE TABLE orders (
  id BIGSERIAL NOT NULL,
  email VARCHAR(255) NOT NULL,
  username VARCHAR(255),
  message VARCHAR(1500),
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now() NOT NULL,
  PRIMARY KEY(id)
);