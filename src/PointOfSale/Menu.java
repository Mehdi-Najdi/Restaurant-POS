package PointOfSale;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] arg) {

        List<String> order = new ArrayList<String>();

        Scanner takeOrder = new Scanner(System.in);

        System.out.print("Table Number? (1 to 10) ");
        byte number = takeOrder.nextByte();

        if (number < 1 || number > 10)
            System.out.println("Table number: 1 to 10! ");

        System.out.println("""
                        Our Menu:
                Pizza ......... £9.99
                Burger ........  £5.99
                Chips .........  £2.99
                Ice_Cream .....  £3.50
                Drinks ........  £2
                """);

        System.out.println("What would you like? ");

        String item;
        float runningTotal = 0;
        String priceFormatted = null;
        while (true) {
            item = takeOrder.nextLine().toLowerCase();
            if (item.equals("stop"))
                break;

            if (item.equals("basket"))
                System.out.println(order);

            switch (item) {
                case "pizza":
                    runningTotal += 9.99;
                    break;
                case "burger":
                    runningTotal += 5.99;
                    break;
                case "chips":
                    runningTotal += 2.99;
                    break;
                case "ice-cream":
                    runningTotal += 3.50;
                    break;
                case "drinks":
                    runningTotal += 2;
                    break;
                default:
                    System.out.println("Please choose from the menu!");
                    continue;
            }

            order.add(item.trim());
            Discount normalDiscount = new Discount();
            Discount exclusiveDiscount = new ExDiscount();

//            addItem(item.trim(), order);
//            removeItem(item, order);
//            cancelOrder(order);

            runningTotal = normalDiscount.calculateDiscount(runningTotal);

            runningTotal = exclusiveDiscount.calculateDiscount(runningTotal);

            priceFormatted = NumberFormat.getCurrencyInstance().format(runningTotal);

            System.out.println("Item Added.");
            System.out.println("select more or type \"basket\" to view your basket! ");
            System.out.println("Or type \"stop\" to place the order! ");
        }
        System.out.println("Table number " + number);
        System.out.println(order);
        System.out.println(priceFormatted);
    }

}
