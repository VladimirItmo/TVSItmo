CREATE TABLE "books" (
                         id bigserial NOT NULL,
                         title character varying(200),
                         author_first_name character varying(200),
                         author_last_name character varying(200),
                         genre character varying(200),
                         publication_year integer,
                         CONSTRAINT "Books_pkey" PRIMARY KEY (id)
);

INSERT INTO books(title, author_first_name, author_last_name, genre, publication_year) VALUES
                                                                                           ('The Catcher in the Rye', 'J.D.', 'Salinger', 'Fiction', 1951),
                                                                                           ('To Kill a Mockingbird', 'Harper', 'Lee', 'Fiction', 1960),
                                                                                           ('1984', 'George', 'Orwell', 'Science Fiction', 1949),
                                                                                           ('Pride and Prejudice', 'Jane', 'Austen', 'Romance', 1813),
                                                                                           ('The Great Gatsby', 'F. Scott', 'Fitzgerald', 'Fiction', 1925),
                                                                                           ('Moby-Dick', 'Herman', 'Melville', 'Adventure', 1851),
                                                                                           ('War and Peace', 'Leo', 'Tolstoy', 'Historical Fiction', 1869),
                                                                                           ('The Lord of the Rings', 'J.R.R.', 'Tolkien', 'Fantasy', 1954),
                                                                                           ('Crime and Punishment', 'Fyodor', 'Dostoevsky', 'Psychological Fiction', 1866),
                                                                                           ('The Hobbit', 'J.R.R.', 'Tolkien', 'Fantasy', 1937),
                                                                                           ('Brave New World', 'Aldous', 'Huxley', 'Science Fiction', 1932),
                                                                                           ('The Chronicles of Narnia', 'C.S.', 'Lewis', 'Fantasy', 1950),
                                                                                           ('Anna Karenina', 'Leo', 'Tolstoy', 'Romantic Fiction', 1877),
                                                                                           ('The Picture of Dorian Gray', 'Oscar', 'Wilde', 'Gothic Fiction', 1890),
                                                                                           ('Frankenstein', 'Mary', 'Shelley', 'Gothic Fiction', 1818),
                                                                                           ('One Hundred Years of Solitude', 'Gabriel Garcia', 'Marquez', 'Magical Realism', 1967),
                                                                                           ('The Brothers Karamazov', 'Fyodor', 'Dostoevsky', 'Philosophical Fiction', 1880),
                                                                                           ('The Odyssey', 'Homer', '', 'Epic Poetry', -800),
                                                                                           ('Alice''s Adventures in Wonderland', 'Lewis', 'Carroll', 'Fantasy', 1865),
                                                                                           ('Wuthering Heights', 'Emily', 'Bronte', 'Gothic Fiction', 1847),
                                                                                           ('Don Quixote', 'Miguel de', 'Cervantes', 'Satire', 1605),
                                                                                           ('The Divine Comedy', 'Dante', 'Alighieri', 'Epic Poetry', 1320),
                                                                                           ('The Count of Monte Cristo', 'Alexandre', 'Dumas', 'Adventure', 1844),
                                                                                           ('Les Miserables', 'Victor', 'Hugo', 'Historical Fiction', 1862),
                                                                                           ('Jane Eyre', 'Charlotte', 'Bronte', 'Gothic Fiction', 1847),
                                                                                           ('Gone with the Wind', 'Margaret', 'Mitchell', 'Historical Fiction', 1936),
                                                                                           ('A Tale of Two Cities', 'Charles', 'Dickens', 'Historical Fiction', 1859),
                                                                                           ('The Alchemist', 'Paulo', 'Coelho', 'Fable', 1988);
