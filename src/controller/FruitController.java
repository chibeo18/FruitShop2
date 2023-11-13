package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import model.Fruit;
import model.Order;

public class FruitController {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Fruit> list_fruit = new ArrayList<>();
    Hashtable<String, ArrayList<Order>> hashtable = new Hashtable<>();
    ArrayList<Order> list_order;

    public FruitController() {
    }

    /**
     * Select list order
     */
    public void viewListOrder() {
        if (hashtable.isEmpty()) {
            System.out.println("No Orders");
            return;
        }
        for (String name : hashtable.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> list_order_check = hashtable.get(name);
            if (list_order_check.isEmpty()) {
                System.out.println("No Orders for this customer");
            } else {
                displayListOrder(list_order_check);
            }
        }
    }

    /**
     * Check fruit name
     * 
     * @param name
     * @return 
     */
    public boolean checkFruit(String name) {
        for (Fruit fruit : list_fruit) {
            if (name.equals(fruit.getName())) {
                System.out.println("Do you want to continue (Y/N)?");
                String choice = scanner.nextLine();
                if (choice.equals("N")) {
                    return false;
                } else if (choice.equals("Y")) {
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * Create fruit
     * 
     * @param fruit 
     */
    public void createFruit(Fruit fruit) {
        if (checkFruit(fruit.getName()) == true) {
            list_fruit.add(fruit);
            displayFruit();
        } else {
            displayFruit();
        }
    }

    /**
     * Select fruit
     */
    public void displayFruit() {
        System.out.println("List of Fruit:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (int i = 0; i < list_fruit.size(); i++) {
            Fruit fruit = list_fruit.get(i);
            System.out.println(String.format("%6d %16s %16s %12s",
                    i + 1, fruit.getName(), fruit.getOrigin(), fruit.getPrice()));
        }
    }

    public void shopping() {
        list_order = new ArrayList<>();
        if (list_fruit.isEmpty()) {
            System.out.println("No Product");
            return;
        }
        displayListOrder(list_order);
        String choice = "Y";
        while (choice.equals("Y")) {
            displayFruit();
            System.out.println("Select item: ");
            int item = scanner.nextInt();
            scanner.nextLine();
            String name = list_fruit.get(item - 1).getName();
            System.out.println("You selected: " + name);
            System.out.print("Please input quantity: ");
            int quantityOrder = scanner.nextInt();
            scanner.nextLine();
            for (Fruit f : list_fruit) {
                if (name.equals(f.getName())) {
                    int id = f.getId();
                    double price = f.getPrice();
                    int quantity = f.getQuantity();
                    if (quantityOrder > quantity) {
                        System.out.println("Quantity Order more than quantity");
                        shopping();
                    }
                    Order order = new Order(id, name, quantityOrder, price);
                    list_order.add(order);
                    System.out.println("Do you want to continue (Y/N)?");
                    choice = scanner.nextLine();
                    if (choice.equals("N")) {
                        displayListOrder(list_order);
                        System.out.print("Enter Customer of name: ");
                        String customer = scanner.nextLine();
                        hashtable.put(customer, list_order);
                        System.out.println("Add Successfully");
                        return;
                    }
                }
            }
        }

    }

    public void displayListOrder(ArrayList<Order> list_o) {
        double totalAmount = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (int i = 0; i < list_o.size(); i++) {
            Order product = list_o.get(i);
            double amount = product.getQuantity() * product.getPrice();
            totalAmount += amount;
            System.out.printf("%d. %-7s %6d %7.2f$ %8.2f$\n",
                    i + 1, product.getName(), product.getQuantity(), product.getPrice(), amount);
        }
        System.out.printf("Total: %.2f$\n", totalAmount);
    }

}
