CREATE TABLE IF NOT EXISTS author(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(1000),
    last_name VARCHAR(1000),
    email VARCHAR(1000)
);

CREATE TABLE IF NOT EXISTS BOOK(
    id SERIAL PRIMARY KEY,
    name VARCHAR(1000),
    count_pages INT,
    author_id INT,
    FOREIGN KEY (author_id)
        REFERENCES author
);

ALTER TABLE AUTHOR
ADD CONSTRAINT EMAIL_UNIQUE UNIQUE (EMAIL);

CREATE TABLE IF NOT EXISTS author_book_relation(
    id SERIAL PRIMARY KEY,
    author_id INT REFERENCES author(id),
    book_id INT REFERENCES BOOK(id),
    UNIQUE(author_id, book_id)
)

INSERT INTO author_book_relation
    (book_id,author_id)
(SELECT id,author_id FROM BOOK);

ALTER TABLE BOOK
	DROP COLUMN author_id;