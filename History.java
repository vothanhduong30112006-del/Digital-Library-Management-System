/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Duong
 */
public class History {

    String ISBN;
    String action;

    public History(String ISBN, String action) {
        this.ISBN = ISBN;
        this.action = action;
    }

    @Override
    public String toString() {
        return action + " - " + ISBN;
    }

}
