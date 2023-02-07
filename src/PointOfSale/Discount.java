package PointOfSale;

public class Discount extends Menu implements CalculateDiscount {
     public float calculateDiscount(float runningTotal) {
        return (float) (runningTotal * 0.9);
    }
}
