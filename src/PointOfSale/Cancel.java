package PointOfSale;

import java.util.List;

public class Cancel extends Menu{
    public static void cancelOrder(String item, List<String> order) {
        if (order.contains(item))
            order.clear();
    }
}
