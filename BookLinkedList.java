
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Duong
 */
public class BookLinkedList {

    Node head;

    public boolean contains(String ISBN) {
        if (ISBN == null || ISBN.trim().isEmpty()) {
            return false;
        }
        ISBN = ISBN.trim();
        Node current = head;
        while (current != null) {
            if (current.data.ISBN.equals(ISBN)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean add(Book book) {
        if (book == null || book.ISBN == null
                || book.ISBN.trim().isEmpty()) {
            return false;
        }

        if (contains(book.ISBN)) {
            return false;
        }
        Node newNode = new Node(book);
        if (head == null) {
            head = newNode;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return true;
    }

    public void display() {
        if (head == null) {
            System.out.println("No available books!");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("[" + current.data.ISBN + "] "
                    + current.data.title + " - " + current.data.author);
            current = current.next;
        }
    }

    public boolean remove(String ISBN) {
        if (ISBN == null || ISBN.trim().isEmpty()) {
            return false;
        }
        ISBN = ISBN.trim();
        if (head == null) {
            return false;
        }
        if (head.data.ISBN.equals(ISBN)) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.ISBN.equals(ISBN)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
