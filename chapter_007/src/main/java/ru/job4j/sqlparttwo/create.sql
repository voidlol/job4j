create table rules(
    id serial primary key,
    name varchar(10)
);

create table roles(
    id serial primary key,
    name varchar(10)
);

create table users(
    id serial primary key,
    name varchar(10),
    role_id int references roles(id)
);

create table role_rules(
    id serial primary key,
    role_id int references roles(id),
    rule_id int references rules(id)
);

create table category(
    id serial primary key,
    name varchar(10)
);

create table states(
    id serial primary key,
    name varchar(10)
);

create table items(
    id serial primary key,
    name varchar(255),
    description text,
    user_id int references users(id),
    category_id int references category(id),
    state_id int references states(id)
);

create table comments(
    id serial primary key,
    comment text,
    item_id int references items(id)
);

create table attach(
    id serial primary key,
    attach text,
    item_id int references items(id)
);
