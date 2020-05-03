import java.io.FileNotFoundException;
import java.util.Scanner;

public class Product_List{
    private int capacity ;
    private int currentSize;
    private Product[] myProduct;

    Product_List(int size){
        myProduct = new Product[size];
        this.capacity = size;
    }

    public void add(Product product){
        ensureCapacity();
        myProduct[currentSize] = (Product) product;
        currentSize++;
    }
    public Product remove(int index){
        if(currentSize == 0){
            return null;
        }
        else if( index == currentSize-1){
            Product token = myProduct[index];
            myProduct[index] = null;
            currentSize--;
            return token;
        }
        else {
            for(int i= index; i< currentSize-1; i++){
                myProduct[i] = myProduct[i+1];
            }
            Product token = myProduct[currentSize-1];
            myProduct[currentSize-1] = null;
            currentSize--;
            return token;
        }
    }
    public void ensureCapacity(){
        if(currentSize == capacity){
            int newCapacity = 2*capacity;
            Product[] myNewProduct = new Product[newCapacity];
            if (currentSize >= 0) System.arraycopy(myProduct, 0, myNewProduct, 0, currentSize);
            myProduct = myNewProduct;
        }
    }
    public int getSize(){
        return currentSize;
    }
//    public void showProduct(){
//        for (Product element: myProduct) {
//            if(element instanceof Freeze_Product){
//                System.out.print("ID: "+ element.getId()+ " name: "+ element.getName()+" price: "+ element.getPrice()+" status: "
//                        + element.getStatusProduct()+" describer: "+ element.getDescriber() + " discount: "+ ((Freeze_Product) element).getDiscount() +"%");
//                System.out.println();
//            }
//            else {
//                System.out.print("ID: "+ element.getId()+ " name: "+ element.getName()+" price: "+ element.getPrice()+" status: "
//                        + element.getStatusProduct()+" describer: "+ element.getDescriber());
//                System.out.println();
//            }
//        }
//    }
    public void showProduct(){
        for (int i=0; i<currentSize; i++) {
            if(myProduct[i] instanceof Freeze_Product){
                System.out.print("ID: "+ myProduct[i].getId()+ " name: "+ myProduct[i].getName()+" price: "+ myProduct[i].getPrice()+" status: "
                        + myProduct[i].getStatusProduct()+" describer: "+ myProduct[i].getDescriber() + " discount: "+ ((Freeze_Product) myProduct[i]).getDiscount() +"%");
                System.out.println();
            }
            else {
                System.out.print("ID: "+ myProduct[i].getId()+ " name: "+ myProduct[i].getName()+" price: "+ myProduct[i].getPrice()+" status: "
                        + myProduct[i].getStatusProduct()+" describer: "+ myProduct[i].getDescriber());
                System.out.println();
            }
        }
    }
    public Product getProduct(int index){
        return myProduct[index];
    }
    public boolean editByID(int id, String name, double price, int status, String describer) throws Exception {
        for (Product element: myProduct
        ) {
            if(element.getId() == id){
                element.setName(name);
                element.setPrice(price);
                element.setStatus(status);
                element.setDescriber(describer);
                return true;
            }
        }
        throw new Exception("ID product not found");
    }
    public Product findByName(String name) throws Exception {
        for (Product element: myProduct
             ) {
            if(element.getName().equalsIgnoreCase(name)){
                element.setName(name);
                return element;
            }
        }
        throw new Exception("Product not found");
    }
}
