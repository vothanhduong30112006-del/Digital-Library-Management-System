/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Duong
 */
public class LibraryManagement {

    BookLinkedList books;
    BookBST searchTree;
    private BookStack history;

    public LibraryManagement() {
        books = new BookLinkedList();
        searchTree = new BookBST();
        history = new BookStack();
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public boolean addBook(String title, String author, String ISBN, boolean isAvailable) {
        if (isBlank(title) || isBlank(author) || isBlank(ISBN)) {
            return false;
        }
        title = title.trim();
        author = author.trim();
        ISBN = ISBN.trim();      
        if (searchTree.search(ISBN) != null) {
            return false;
        }

        Book book = new Book(title, author, ISBN, isAvailable);
        if (!searchTree.insert(book)) {
            return false;
        }
        if (isAvailable) {
            if (!books.add(book)) {
                searchTree.delete(ISBN);
                return false;
            }
        }

        return true;
    }

    public void displayBooks() {
        books.display();
    }

    public Book searchBook(String ISBN) {
        if (isBlank(ISBN)) {
            return null;
        }
        return searchTree.search(ISBN.trim());
    }

    public boolean deleteBook(String ISBN) {
        if (isBlank(ISBN)) {
            return false;
        }
        Book book = searchTree.search(ISBN.trim());
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        if (!book.isAvailable) {
            System.out.println("Cannot delete borrowed book!");
            return false;
        }
        if (!books.remove(ISBN.trim())) {
            System.out.println("Cannot remove book from Linked List!");
            return false;
        }
        if (!searchTree.delete(ISBN.trim())) {
            books.add(book);
            return false;
        }
        System.out.println("Delete successful!");
        return true;
    }

    public boolean borrowBook(String ISBN) {
        if (isBlank(ISBN)) {
            System.out.println("ISBN must not be empty!");
            return false;
        }
        Book book = searchTree.search(ISBN.trim());
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        if (!book.isAvailable) {
            System.out.println("Book is already borrowed!");
            return false;
        }
        if (!books.remove(book.ISBN)) {
            System.out.println("Cannot update Linked List!");
            return false;
        }
        book.isAvailable = false;
        history.push(new History(book.ISBN, "BORROW"));
        System.out.println("Borrow successful: " + book.title);
        return true;
    }

    public boolean returnBook(String ISBN) {
        if (isBlank(ISBN)) {
            System.out.println("ISBN must not be empty!");
            return false;
        }
        Book book = searchTree.search(ISBN.trim());
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        if (book.isAvailable) {
            System.out.println("Book has not been borrowed!");
            return false;
        }
        book.isAvailable = true;
        if (!books.add(book)) {
            book.isAvailable = false;
            System.out.println("Cannot update Linked List!");
            return false;
        }
        history.push(new History(book.ISBN, "RETURN"));
        System.out.println("Return successful: " + book.title);
        return true;
    }

    public void displayHistory() {
        history.display();
    }
}
