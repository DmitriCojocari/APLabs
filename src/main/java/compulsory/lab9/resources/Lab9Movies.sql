CL SCR;

DROP TABLE movies;
/
DROP TABLE genres;
/
DROP TABLE movie_genres;
/

CREATE TABLE movies (
id INT NOT NULL PRIMARY KEY,
title VARCHAR2(25) NOT NULL,
release_date DATE,
movie_duration NUMBER,
rating FLOAT
)
/

CREATE TABLE genres (
id INT NOT NULL PRIMARY KEY,
genre_name VARCHAR2(20) NOT NULL
)
/

CREATE TABLE movie_genres (
id_movie INT NOT NULL ,
id_genre INT NOT NULL,
CONSTRAINT movie_genres_ID_PK PRIMARY KEY (id_movie,id_genre)
)
/

INSERT INTO movies VALUES(1, 'The Day After Tomorrow', TO_DATE('17/05/2004', 'DD/MM/YYYY'), 124, 6.4);
INSERT INTO movies VALUES(2, '1+1', TO_DATE('02/11/2011', 'DD/MM/YYYY'), 113, 8.8);
INSERT INTO movies VALUES(3, 'The Fault In Our Stars', TO_DATE('02/06/2014', 'DD/MM/YYYY'), 133, 7.7);
INSERT INTO movies VALUES(4, 'Paper Towns', TO_DATE('09/07/2015', 'DD/MM/YYYY'), 113, 6.3);
INSERT INTO movies VALUES(5, 'Last Dance', TO_DATE('19/04/2020', 'DD/MM/YYYY'), 40, 9);

INSERT INTO genres VALUES(1, 'Thriller');
INSERT INTO genres VALUES(2, 'Comedy');
INSERT INTO genres VALUES(3, 'Drama');
INSERT INTO genres VALUES(4, 'Detective');
INSERT INTO genres VALUES(5, 'Sports');

INSERT INTO movie_genres VALUES(1, 1);
INSERT INTO movie_genres VALUES(2, 2);
INSERT INTO movie_genres VALUES(3, 3);
INSERT INTO movie_genres VALUES(4, 4);
INSERT INTO movie_genres VALUES(5, 5);

COMMIT;

SET SERVEROUTPUT ON;

select * from movies WHERE title = '1+1';