-- intellica_movieappdb

create table movies (
    movie_id bigserial primary key,
    name varchar(256) not null,
    scene_date date not null,
    rating bigint not null default(0) check(rating >= 0),
    cost real not null,
    imdb float4 not null default(0.0)
);

create table directors (
    director_id bigserial primary key,
    first_name varchar(100) not null,
    middle_name varchar(100),
    family_name varchar(100) not null,
    birth_date date not null
);

create table movies_to_director (
    movies_to_director_id bigserial primary key,
    movie_id bigint references movies(movie_id),
    director_id bigint references directors(director_id)
);