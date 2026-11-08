/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Duong
 */
public class Book {
    String title;
    String author;
    String ISBN;
    boolean isAvailable;

    public Book(String title, String author, String ISBN, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", isAvailable=" + isAvailable + '}';
    }
    
}
