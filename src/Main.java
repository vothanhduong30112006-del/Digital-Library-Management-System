/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Duong
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagement lib = new LibraryManagement();

        // Du lieu mau
        lib.addBook("Data Structures", "Nguyen Van A", "300", true);
        lib.addBook("Java Basics", "Tran Thi B", "150", true);
        lib.addBook("Computational Thinking", "Le Van C", "450", true);

        int choice = -1;
        do {
            System.out.println("\n===== DIGITAL LIBRARY MANAGEMENT =====");
            System.out.println("1. Add book");
            System.out.println("2. Search book by ISBN (BST)");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Show available books (Linked List)");
            System.out.println("6. Show borrow/return history (Stack)");
            System.out.println("7. Delete book");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.print("Title : ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("ISBN  : ");
                    String isbn = sc.nextLine();
                    if (lib.addBook(title, author, isbn, true)) {
                        System.out.println("Added successfully!");
                    } else {
                        System.out.println("Cannot add (empty field or duplicate ISBN)!");
                    }
                    break;
                case 2:
                    System.out.print("ISBN: ");
                    Book b = lib.searchBook(sc.nextLine());
                    System.out.println(b == null ? "Book not found!" : b);
                    break;
                case 3:
                    System.out.print("ISBN: ");
                    lib.borrowBook(sc.nextLine());
                    break;
                case 4:
                    System.out.print("ISBN: ");
                    lib.returnBook(sc.nextLine());
                    break;
                case 5:
                    lib.displayBooks();
                    break;
                case 6:
                    lib.displayHistory();
                    break;
                case 7:
                    System.out.print("ISBN: ");
                    lib.deleteBook(sc.nextLine());
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        sc.close();
    }
}