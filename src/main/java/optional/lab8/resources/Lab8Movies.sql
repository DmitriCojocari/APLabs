CL SCR;

DROP TABLE movie_imdb;
/
DROP TABLE actors;
/
DROP TABLE directors;
/

CREATE TABLE movie_imdb (
movie_id VARCHAR2(50) PRIMARY KEY NOT NULL,
title VARCHAR2(200) NOT NULL,
release_year VARCHAR2(50) NOT NULL,
movie_duration int NOT NULL,
rating float NOT NULL

)
/

CREATE TABLE actors ( 
movie_id VARCHAR2(50)PRIMARY KEY NOT NULL,
actor_name VARCHAR2(1000)
)
/

CREATE TABLE directors ( 
movie_id VARCHAR2(50)PRIMARY KEY NOT NULL,
director_name VARCHAR2(120)
)
/


SELECT * FROM movie_imdb;

