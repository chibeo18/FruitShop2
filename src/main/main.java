/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.FruitController;
import java.util.Scanner;
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
        View taskView = new View();
        FruitController taskControl = new FruitController();

        do {
            taskView.display();
            System.out.print("Choice option:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    taskControl.createFruit();
                    break;
                case 2:
                    taskControl.viewListOrder();
                    break;
                case 3:
                    taskControl.shopping();
                    break;
                case 4:
                    break;
                default:
                    break;
            }

        } while (choice != 4);

    }

}
