-- japp1o21_moviesappdb

create table movies (
    movie_id bigserial primary key,
    name varchar(256) not null,
    scene_date date not null,
    rating bigint default(0) not null,
    cost real not null,
    imdb real
);


create table directors (
    email varchar(50) primary key,
    first_name varchar(100) not null,
    middle_name varchar(100),
    family_name varchar(100) not null,
    birth_date date not null
);

create table movies_to_directors (
    movies_to_directors_id bigserial primary key,
    movie_id bigint references movies(movie_id),
    email varchar(50) references directors(email),
    register_date date  default(current_date) not null
);