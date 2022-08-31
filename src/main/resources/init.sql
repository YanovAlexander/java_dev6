CREATE TABLE author(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(1000),
    last_name VARCHAR(1000),
    email VARCHAR(1000)
);

CREATE TABLE BOOK(
    id SERIAL PRIMARY KEY,
    name VARCHAR(1000),
    count_pages INT,
    author_id INT,
    FOREIGN KEY (author_id)
        REFERENCES author
);

ALTER TABLE AUTHOR
ADD CONSTRAINT EMAIL_UNIQUE UNIQUE (EMAIL);