package PointOfSale;

import java.util.List;

public class Cancel extends Menu{
    public static void cancelOrder(List<String> order) {
        order.clear();
    }
}
