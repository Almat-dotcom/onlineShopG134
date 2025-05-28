create table items
(
    id            bigserial primary key,
    name          varchar(255) not null,
    description   text not null,
    color         varchar(255) not null,
    size          int not null,
    price          int not null,
    is_available   boolean not null,
    created_date  timestamp,
    modified_date timestamp,
    brand_id      bigint not null references brands(id),
    gender_id     bigint references genders(id)
);

create table item_categories
(
    item_id bigint not null references items(id),
    category_id bigint not null references categories(id),
    primary key (item_id, category_id)
);