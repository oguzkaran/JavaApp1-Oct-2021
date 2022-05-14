insert into members (username, password, first_name, last_name, enabled, register_date) values ('csds', 'csd1993', 'CSD', 'CSD', true, current_date);

insert into member_roles (role, member_id) values ('ROLE_SYS_ADMIN', 1);