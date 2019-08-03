INSERT INTO orders
VALUES (1, '');
select nextval('orders_id_seq');

INSERT INTO history
VALUES (1, 6, '2019-08-01 14:14:25.805', 1, 3);
select nextval('history_id_seq');

INSERT INTO order_dish
VALUES (1, 1, 1, 3);
select nextval('order_dish_id_seq');

INSERT INTO orders
VALUES (2, '');
select nextval('orders_id_seq');

INSERT INTO history
VALUES (2, 6, '2019-08-01 15:14:25.805', 2, 3);
select nextval('history_id_seq');

INSERT INTO order_dish
VALUES (2, 2, 2, 4);
select nextval('order_dish_id_seq');

INSERT INTO order_dish
VALUES (3, 1, 2, 1);
select nextval('order_dish_id_seq');

