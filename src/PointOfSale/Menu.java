package PointOfSale;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
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

            //order = addItem(order);
            addItem(item.trim(), order);
            //order = removeItem(order);
            removeItem(item, order);
            cancelOrder(order);
            runningTotal = calculateDiscount(runningTotal);

            priceFormatted = NumberFormat.getCurrencyInstance().format(runningTotal);

            //order.add(item.trim());

            System.out.println("Item Added.");
            System.out.println("select more or type \"basket\" to view your basket! ");
            System.out.println("Or type \"stop\" to place the order! ");
        }
        System.out.println("Table number " + number);
        System.out.println(order);
        System.out.println(priceFormatted);
    }
    private static float calculateDiscount(float runningTotal) {
        return (float) (runningTotal * 0.9);
    }

    public static void addItem(String item, List<String> order) {
        order.add(item.trim());
    }

//    public static List addItem(List<String> order){
//
//        return Collections.singletonList(order.add(String.valueOf(order)));
//    }
//    public static List removeItem(List<String> order){
//        return Collections.singletonList(order.remove(order));
//    }

    public static void removeItem(String item, List<String> order)
    {
        if (order.contains(item))
            order.remove(item);
        else
            System.out.println("order does not contain " + item);
    }
    public static void cancelOrder(List<String> order){
         order.clear();
    }
}
