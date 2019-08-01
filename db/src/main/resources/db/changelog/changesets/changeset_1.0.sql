CREATE TABLE ingredients
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL UNIQUE,
    measure VARCHAR(50) NOT NULL
);
CREATE TABLE ingredient_parts
(
    id              SERIAL PRIMARY KEY,
    ingredient_id   INTEGER          NOT NULL,
    value           DOUBLE PRECISION NOT NULL,
    expiration_date TIMESTAMP        NOT NULL,
    FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);
CREATE TABLE dishes
(
    id     SERIAL PRIMARY KEY,
    name   VARCHAR(50)      NOT NULL,
    cost   DOUBLE PRECISION NOT NULL,
    type   VARCHAR(50)      NOT NULL,
    ismenu BOOLEAN          NOT NULL
);
CREATE TABLE dish_ingredient
(
    id            SERIAL PRIMARY KEY,
    dish_id       INTEGER          NOT NULL,
    value         DOUBLE PRECISION NOT NULL,
    ingredient_id INTEGER          NOT NULL,
    FOREIGN KEY (dish_id) REFERENCES dishes (id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);
