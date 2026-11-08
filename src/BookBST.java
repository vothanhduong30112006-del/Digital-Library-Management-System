/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Duong
 */
public class BookBST {
    TreeNode root;
    public boolean insert(Book book) {
        if (book == null) {
            return false;
        }
        if (search(book.ISBN) != null) {
            return false;
        }
        root = insertRec(root, book);
        return true;
    }
    private TreeNode insertRec(TreeNode root, Book book) {
        if (root == null) {
            return new TreeNode(book);
        }
        int compare = book.ISBN.compareTo(root.data.ISBN);
        if (compare < 0) {
            root.left = insertRec(root.left, book);
        } else if (compare > 0) {
            root.right = insertRec(root.right, book);
        }
        return root;
    }
    public Book search(String ISBN) {
        TreeNode current = root;
        while (current != null) {
            int compare = ISBN.compareTo(current.data.ISBN);
            if (compare == 0) {
                return current.data;
            } else if (compare < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
    public boolean delete(String ISBN) {
        if (search(ISBN) == null) {
            return false;
        }
        root = deleteRec(root, ISBN);
        return true;
    }
    private TreeNode deleteRec(TreeNode root, String ISBN) {
        if (root == null) {
            return null;
        }
        int compare = ISBN.compareTo(root.data.ISBN);
        if (compare < 0) {
            root.left = deleteRec(root.left, ISBN);
        } else if (compare > 0) {
            root.right = deleteRec(root.right, ISBN);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.data = minNode.data;
            root.right = deleteRec(root.right, minNode.data.ISBN);
        }
        return root;
    }
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public void display() {
        if (root == null) {
            System.out.println("No books in BST!");
            return;
        }
        displayInOrder(root);
    }
    private void displayInOrder(TreeNode root) {
        if (root != null) {
            displayInOrder(root.left);
            System.out.println(root.data);
            displayInOrder(root.right);
        }
    }
}
