create table brands
(
    id            bigserial primary key,
    name          varchar(255) not null,
    created_date  timestamp,
    modified_date timestamp
)