package PointOfSale;

public class ExDiscount extends Discount implements CalculateDiscount {
    public float calculateDiscount(float runningTotal) {
        return (float) (runningTotal * 0.19);
    }
}
