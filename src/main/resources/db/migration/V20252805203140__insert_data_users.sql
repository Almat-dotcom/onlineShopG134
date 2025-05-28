insert into roles(name, description, created_date, modified_date)
values ('ROLE_ADMIN', 'Role for Admins', current_timestamp, current_timestamp),
       ('ROLE_MANAGER', 'Role for Managers', current_timestamp, current_timestamp),
       ('ROLE_USER', 'Role for Users', current_timestamp, current_timestamp);

insert into users(username, password, full_name, age, created_date, modified_date)
values ('admin', '$2a$12$whK0Z7iyH7R.utj3YHSHYuTw5PW/ojUsE4cCLulOWdUMA1gaLw836', 'ADMIN ADMIN', 30, current_timestamp,
        current_timestamp),
       ('manager', '$2a$12$whK0Z7iyH7R.utj3YHSHYuTw5PW/ojUsE4cCLulOWdUMA1gaLw836', 'MANAGER MANAGER', 28,
        current_timestamp, current_timestamp),
       ('user', '$2a$12$whK0Z7iyH7R.utj3YHSHYuTw5PW/ojUsE4cCLulOWdUMA1gaLw836', 'USER USER', 25, current_timestamp,
        current_timestamp);

insert into user_roles(user_id, role_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 2),
       (2, 3),
       (3, 3);