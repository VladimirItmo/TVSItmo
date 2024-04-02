package com.soap;

public class Books {
    private int books_id;
    private String title;
    private String author_first_name;
    private String author_last_name;
    private String genre;
    private int publication_year;

    public Books(int id, String title, String author_first_name, String author_last_name,  String genre, int publication_year) {
        this.books_id = id;
        this.title = title;
        this.author_first_name = author_first_name;
        this.author_last_name = author_last_name;
        this.genre = genre;
        this.publication_year = publication_year;
    }
    public int getBooks_id() { return books_id; }
    public String getTitle() {
        return title;
    }
    public String getAuthor_first_name() {
        return author_first_name;
    }
    public String getAuthor_last_name() {
        return author_last_name;
    }
    public String getGenre() {
        return genre;
    }
    public int getPublication_year() {
        return publication_year;
    }

    public void setBooks_id(int books_id){ this.books_id = books_id; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }
    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }


    @Override
    public String toString() {
        return "Books{" + "id" + books_id + "title=" + title + ", author_first_name=" +  author_first_name +", author_last_name=" + author_last_name +
                ", genre=" + genre + ", publication_year=" + publication_year + "}";
    }
}