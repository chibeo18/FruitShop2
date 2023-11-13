/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.FruitController;
import java.util.Scanner;
import model.Fruit;
import view.View;

/**
 *
 * @author quang
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int choice;
        View view = new View();
        FruitController fruitController = new FruitController();

        do {
            // select menu
            view.display();
            System.out.print("Choice option:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Fruit fruit = view.createFruit();
                    fruitController.createFruit(fruit);
                    break;
                case 2:
                    fruitController.viewListOrder();
                    break;
                case 3:
                    fruitController.shopping();
                    break;
                default:
                    break;
            }

        } while (choice != 4);

    }

}
