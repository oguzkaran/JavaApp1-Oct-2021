create table random_user_info (
    random_user_info_id serial primary key,
    first varchar(256) not null,
    last varchar(256) not null,
    data_info json not null,
    save_datetime timestamp default(current_timestamp) not null
);


