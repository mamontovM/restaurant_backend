insert into roles(name)
values ('Администратор');
insert into roles(name)
values ('Повар');
insert into roles(name)
values ('Официант');
insert into roles(name)
values ('Провизор');
insert into users (login, password, name, surname, role_id)
values ('admin', '123456', 'Андрей', 'Соколов', 1);
insert into users (login, password, name, surname, role_id)
values ('cook', '123456', 'Егор', 'Стаханов', 2);
insert into users (login, password, name, surname, role_id)
values ('waiter', '123456', 'Илья', 'Воробьёв', 3);
insert into users (login, password, name, surname, role_id)
values ('storekeeper', '123456', 'Евгений', 'Жердин', 4);
