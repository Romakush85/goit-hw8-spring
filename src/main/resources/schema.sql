    CREATE TABLE producers (
       id UUID NOT NULL,
        name VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    );

    create table products (
       id uuid not null,
        name varchar(255) not null,
        price numeric(38,2) not null,
        producer_id uuid not null,
        primary key (id)
    );

    create table user_dao_roles (
       user_dao_id uuid not null,
        roles varchar(255)
    );

    create table users (
       id uuid not null,
        email varchar(255) not null,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    alter table if exists users
       add constraint UK_email unique (email);

    alter table if exists products
       add constraint FK_producers_producer_id
       foreign key (producer_id)
       references producers
       on delete cascade;

    alter table if exists user_dao_roles
       add constraint FK_users_user_dao_id
       foreign key (user_dao_id)
       references users;
