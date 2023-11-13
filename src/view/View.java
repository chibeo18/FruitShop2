package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;

public class View {

    ArrayList<Fruit> list_fruit = new ArrayList<>();

    /**
     * select menu
     */
    public void display() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("--------------------------------");
        System.out.println("1.Create Fruit");
        System.out.println("2.View Orders");
        System.out.println("3.Shopping (for buyer)");
        System.out.println("4.Exit");
    }

    /**
     * select view enter fruit
     *
     * @return
     */
    public Fruit createFruit() {
        Scanner scanner = new Scanner(System.in);

        int id = list_fruit.size() + 1;
        System.out.println("Enter fruit name: ");
        String name = scanner.nextLine();

        System.out.println("Enter fruit price: ");
        double price = scanner.nextDouble();

        System.out.println("Enter fruit quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter fruit origin: ");
        String origin = scanner.nextLine();
        
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setName(name);
        fruit.setPrice(price);
        fruit.setOrigin(origin);
        fruit.setQuantity(quantity);

        return fruit;
    }
}
