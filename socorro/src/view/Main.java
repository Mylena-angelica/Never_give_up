package view;

import javax.swing.JFrame;

import model.Dados;

/**
 *
 * @author mylen
 */
public class Main {   

    public static void main(String[] args) {
       new Dados();

       JFrame Menu = new Menu();
       Menu.setVisible(true);
    }
}