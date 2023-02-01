public class PricePolicy {
    private double factor = 1;


    public void setPrice (double factor) {
        this.factor = factor;
    }
    public double getPrice(double price) {
        return price * factor;
    }
};
