ALTER TABLE ingredients
    ADD volume_per_unit DOUBLE PRECISION NOT NULL DEFAULT '0';
UPDATE ingredients
SET volume_per_unit=0.05
WHERE id = 1;
UPDATE ingredients
SET volume_per_unit=0.02
WHERE id = 2;
UPDATE ingredients
SET volume_per_unit=0.001
WHERE id = 3;
UPDATE dishes
SET name='Яичница'
WHERE id = 2;

CREATE TABLE restaurant_config
(
    id                 integer                     NOT NULL PRIMARY KEY,
    max_storage_volume DOUBLE PRECISION DEFAULT 25 NOT NULL
);

INSERT INTO restaurant_config
VALUES (1, 26);

