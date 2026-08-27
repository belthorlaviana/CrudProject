DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS category CASCADE;

CREATE TABLE category (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(255)
);

CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         category_id INTEGER NOT NULL,
                         CONSTRAINT fk_category
                             FOREIGN KEY (category_id)
                                 REFERENCES category(id)
);
