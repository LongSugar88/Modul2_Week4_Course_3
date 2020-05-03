import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Product_File_Manager myManager = new Product_File_Manager();
//        Product_List myList = new Product_List(10);
        MyArrayList<Product> myList = new MyArrayList<>(10);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file link: ");
        String link = scan.nextLine();
        myManager.CloneProductListFromFile(link, myList);
        System.out.println(myList.getSize());
        myList.showProduct();

        Comparator mycompare = new Comparator();
        Collections.sort(myList, mycompare);
        System.out.println("Enter file link to save: ");
//        String linkSave = scan.nextLine();
//        myManager.SaveProductListToFile(linkSave, myList);
    }
}
