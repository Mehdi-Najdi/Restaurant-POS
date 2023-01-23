package PointOfSale;

import java.util.Collections;
import java.util.List;

public class Menu {
    private static float calculateDiscount(float runningTotal) {
        return (float) (runningTotal * 0.9);
    }
    public static List addItem(List<String> order){

        return Collections.singletonList(order.add(String.valueOf(order)));
    }
    public static List removeItem(List<String> order){
        return Collections.singletonList(order.remove(order));
    }
    public static void cancelOrder(List<String> order){
         order.clear();
    }
}
