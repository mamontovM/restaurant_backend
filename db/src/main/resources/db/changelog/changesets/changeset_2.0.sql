create table roles
(
    id   serial      not null
        constraint roles_pkey
            primary key,
    name varchar(50) not null
)
;

alter table roles
    owner to postgres
;

create table users
(
    id       serial      not null
        constraint users_pkey
            primary key,
    login    varchar(40) not null,
    password varchar(40) not null,
    name     varchar(40) not null,
    surname  varchar(40) not null,
    role_id  integer
        constraint users_roles_id_fk
            references roles
)
;

alter table users
    owner to postgres
;

create table waiter_orders
(
    id            serial    not null
        constraint waiter_orders_pkey
            primary key,
    time_of_take  timestamp not null,
    time_of_given timestamp,
    isready       boolean,
    "user"        integer
        constraint waiter_orders_users_id_fk
            references users
)
;

alter table waiter_orders
    owner to postgres
;

create table cook_orders
(
    id            serial    not null
        constraint cook_orders_pkey
            primary key,
    time_of_take  timestamp not null,
    time_of_given timestamp,
    isready       boolean,
    "user"        integer
        constraint cook_orders_users_id_fk
            references users
)
;

alter table cook_orders
    owner to postgres
;

create table orders
(
    id        serial not null
        constraint orders_pkey
            primary key,
    cook_id   integer
        constraint orders_cook_orders_id_fk
            references cook_orders,
    waiter_id integer
        constraint orders_waiter_orders_id_fk
            references waiter_orders,
    comments  varchar(200)
)
;

alter table orders
    owner to postgres
;

create table order_dish
(
    id       serial  not null
        constraint order_dish_pkey
            primary key,
    dish_id  integer not null
        constraint order_dish_dish_id_fkey
            references dishes,
    order_id integer not null
        constraint order_dish_order_id_fkey
            references orders
)
;

alter table order_dish
    owner to postgres
;

