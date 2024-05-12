create table students
(
    id SERIAL PRIMARY KEY,
    first_name TEXT not null,
    last_name TEXT not null,
    birthdate date null,
    major_id int null,
    image bytea null
);

create table majors
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    description TEXT not null
);

create table courses
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    hours int not null
);

create table student_course
(
    id SERIAL PRIMARY KEY,
    student_id int not null,
    course_id int not null
);


create table users
(
    id SERIAL PRIMARY KEY,
    nom varchar not null,
    roles varchar not null,
    prenom varchar not null,
    email varchar not null ,
    password_mdp varchar not null,
    score int default 0
);


drop table if exists questions cascade ;
CREATE TABLE questions (
                           id SERIAL PRIMARY KEY,
                           question VARCHAR NOT NULL,
                           reponse VARCHAR NOT NULL,
                           choices TEXT,  -- Stores multiple choices as a comma-separated string (optional)
                           hint TEXT  -- Stores the optional hint for the question
);
drop table if exists quizz;
CREATE TABLE quizz (
                       id SERIAL PRIMARY KEY,
                       titre varchar NOT NULL,
                       question_id TEXT,
                       image BYTEA
);

create table question_quizz
(
    id SERIAL PRIMARY KEY,
    question_id int not null,
    quizz_id int not null
);
