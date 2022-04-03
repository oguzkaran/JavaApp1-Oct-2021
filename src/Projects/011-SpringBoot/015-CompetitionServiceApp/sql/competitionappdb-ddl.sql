create table authors (
    email varchar(50) primary key not null,
    name varchar(100) not null,
    register_date date default(current_date) not null
);

create table questions (
    question_id serial primary key,
    text varchar(4096) not null,
    level int default(1) not null,
    entry_date timestamp default(current_timestamp) not null,
    email varchar(50) references authors(email) not null
);

create table options (
     option_id serial primary key,
     ordinal char(1) not null,
     text varchar(100) not null,
     is_answer bool not null,
     question_id int references questions(question_id) not null
);

