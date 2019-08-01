INSERT INTO ingredients
VALUES (1, 'Картофель', 'кг');
select nextval('ingredients_id_seq');
INSERT INTO ingredients
VALUES (2, 'Молоко', 'л');
select nextval('ingredients_id_seq');
INSERT INTO ingredients
VALUES (3, 'Яйца', 'шт');
select nextval('ingredients_id_seq');

INSERT INTO ingredient_parts
VALUES (1, 1, 30, '2019-08-08');
select nextval('ingredient_parts_id_seq');
INSERT INTO ingredient_parts
VALUES (2, 1, 10, '2019-07-18');
select nextval('ingredient_parts_id_seq');
INSERT INTO ingredient_parts
VALUES (3, 2, 1.2, '2019-07-18');
select nextval('ingredient_parts_id_seq');
INSERT INTO ingredient_parts
VALUES (4, 2, 13, '2019-08-18');
select nextval('ingredient_parts_id_seq');

INSERT INTO dishes
VALUES (1, 'Жаренная картошка', 100, 'первое', true);
select nextval('dishes_id_seq');
INSERT INTO dishes
VALUES (2, 'Яичнеца', 120, 'первое', true);
select nextval('dishes_id_seq');
INSERT INTO dishes
VALUES (3, 'Омлет', 150, 'первое', true);
select nextval('dishes_id_seq');
INSERT INTO dishes
VALUES (4, 'Дранники', 80, 'первое', false);
select nextval('dishes_id_seq');

INSERT INTO dish_ingredient
VALUES (1, 1, 0.8, 1);
select nextval('dish_ingredient_id_seq');
INSERT INTO dish_ingredient
VALUES (2, 1, 0.2, 2);
select nextval('dish_ingredient_id_seq');
INSERT INTO dish_ingredient
VALUES (3, 2, 3, 3);
select nextval('dish_ingredient_id_seq');
INSERT INTO dish_ingredient
VALUES (4, 3, 0.6, 2);
select nextval('dish_ingredient_id_seq');
INSERT INTO dish_ingredient
VALUES (5, 3, 2, 3);
select nextval('dish_ingredient_id_seq');
