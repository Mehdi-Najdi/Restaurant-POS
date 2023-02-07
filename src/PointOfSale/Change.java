package PointOfSale;

import java.util.List;

public interface Change {
    void addItem(String item, List<String> order);
    void removeItem(String item, List<String> order);
}
