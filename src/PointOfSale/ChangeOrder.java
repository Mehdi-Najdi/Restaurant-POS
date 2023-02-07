package PointOfSale;

import java.util.List;

public class ChangeOrder extends Menu implements Change {
    public void addItem(String item, List<String> order) {
        order.add(item.trim());
    }

    public void removeItem(String item, List<String> order) {
        if (order.contains(item))
            order.remove(item);
        else
            System.out.println("order does not contain " + item);
    }
}
