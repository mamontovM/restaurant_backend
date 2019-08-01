create table roles
(
	id serial not null
		constraint roles_pkey
			primary key,
	name varchar(50) not null
)
;

alter table roles owner to postgres
;

create table users
(
	id serial not null
		constraint users_pkey
			primary key,
	login varchar(40) not null,
	password varchar(256) not null,
	name varchar(40) not null,
	surname varchar(40) not null,
	role_id integer
		constraint users_roles_id_fk
			references roles
)
;

alter table users owner to postgres
;

create unique index users_login_uindex
	on users (login)
;

create table orders
(
	id serial not null
		constraint orders_pk
			primary key,
	comments varchar(200)
)
;

alter table orders owner to postgres
;



create table order_dish
(
	id serial not null
		constraint order_dish_pkey
			primary key,
	dish_id integer not null
		constraint order_dish_dish_id_fkey
			references dishes,
	order_id integer not null
		constraint order_dish_order_id_fkey
			references orders,
	count integer
)
;

alter table order_dish owner to postgres
;

create table status
(
	id serial not null
		constraint status_pkey
			primary key,
	name varchar(100)
)
;

alter table status owner to postgres
;



create table history
(
	id serial not null
		constraint history_pkey
			primary key,
	status_id integer
		constraint history_status_id_fk
			references status,
	time timestamp,
	order_id integer
		constraint history_orders_id_fk
			references orders,
	user_id integer
		constraint history_users_id_fk
			references users
)
;

alter table history owner to postgres
;

