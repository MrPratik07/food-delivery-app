create table IF NOT EXISTS food (
    id bigint not null,
    name varchar(255) not null,
    price bigint not null,
    primary key(id)
);

create table IF NOT EXISTS user_detail (
    id bigint not null,
    name varchar(255) not null,
    primary key(id)
);