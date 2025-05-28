insert into genders(name, created_date, modified_date)
values ('male', current_timestamp, current_timestamp),
       ('female', current_timestamp, current_timestamp);

insert into brands(name, created_date, modified_date)
values ('Nike', current_timestamp, current_timestamp),
       ('Adidas', current_timestamp, current_timestamp),
       ('Puma', current_timestamp, current_timestamp);

insert into categories(name, created_date, modified_date)
values ('Training', current_timestamp, current_timestamp),
       ('Winter', current_timestamp, current_timestamp),
       ('Summer', current_timestamp, current_timestamp);

insert into items(name, description, color, size, price, is_available, brand_id, gender_id, created_date, modified_date)
values ('Nike Air Max', 'Comfortable running shoes', 'Black', 42, 120, true, 1, 1,  current_timestamp, current_timestamp),
       ('Adidas Ultraboost', 'High-performance running shoes', 'White', 40, 150, true, 2, 2,  current_timestamp, current_timestamp),
       ('Puma RS-X', 'Stylish sneakers for everyday wear', 'Blue', 44, 110, true, 3, 2, current_timestamp, current_timestamp);

insert into item_categories(item_id, category_id)
values (1, 1),
       (2, 2),
       (3, 1),
       (3, 3);

