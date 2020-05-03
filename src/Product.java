public class Product {
    private int id;
    private String name;
    private double price;
    private int status;
    private String describer;
    Product(){

    }
    public Product(int id, String name, double price, int status, String describer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.describer = describer;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    protected String getStatusProduct(){
        if(this.status == 0){
            return "Empty";
        } else if(this.status == 2){
            return "available";
        } else if(this.status == 1){
            return "almost over";
        } else {
            return "no information";
        }
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }
}
