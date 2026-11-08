/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Duong
 */
public class BookStack {

    StackNode top;

    public void push(History history) {
        StackNode newNode = new StackNode(history);

        newNode.next = top;
        top = newNode;
    }

    public History pop() {
        if (top == null) {
            return null;
        }
        History result = top.data;
        top = top.next;
        return result;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public History peek() {
        return top == null ? null : top.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No history yet!");
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
