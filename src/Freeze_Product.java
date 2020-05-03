public class Freeze_Product extends Product implements Discount {
    private double discount;
    Freeze_Product(int id, String name, double price, int status, String describer, double discount){
        super(id, name, price, status, describer);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double discount(double saleOff) {
        this.discount = saleOff/100;
        return discount;
    }
}
