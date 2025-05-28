create table genders
(
    id            bigserial primary key,
    name          varchar(255) not null,
    created_date  timestamp,
    modified_date timestamp
);

create table categories
(
    id            bigserial primary key,
    name          varchar(255) not null,
    created_date  timestamp,
    modified_date timestamp
)