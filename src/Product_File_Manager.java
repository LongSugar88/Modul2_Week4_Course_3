import java.io.*;

public class Product_File_Manager {
    void CloneProductListFromFile(String link, Product_List list){
        try{
            File file = new File(link);
            if(!file.exists()) throw new FileNotFoundException("File not found");
            FileReader fileReader = new FileReader(file);
            BufferedReader buffFileReader = new BufferedReader(fileReader);
            String content = null;
            while ((content = buffFileReader.readLine()) != null){
                String[] myInfor = content.split(",");
                String type1 = myInfor[0];
//                int type = Integer.parseInt(type1);
                if(type1.equals("2")){
                    Product newProduct = new Freeze_Product(Integer.parseInt(myInfor[1]), myInfor[2],Double.parseDouble(myInfor[3]), Integer.parseInt(myInfor[4]), myInfor[5], Double.parseDouble(myInfor[6]));
                    list.add(newProduct);
                }
                else if (type1.equals("1")){
                    Product newProduct = new Dry_Product(Integer.parseInt(myInfor[1]), myInfor[2],Double.parseDouble(myInfor[3]), Integer.parseInt(myInfor[4]), myInfor[5]);
                    list.add(newProduct);
                }
            }
            buffFileReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    void SaveProductListToFile(String link, Product_List list){
        try{
            File file = new File(link);
            if(!file.exists()) throw new FileNotFoundException("File not found");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0; i< list.getSize(); i++){
                if(list.getProduct(i) instanceof Dry_Product){
                    String content = list.getProduct(i).getId() + "," + list.getProduct(i).getName() +
                            "," + list.getProduct(i).getPrice() + "," + list.getProduct(i).getStatus() +
                            "," + list.getProduct(i).getDescriber();
                    bufferedWriter.write(content);
                    bufferedWriter.newLine();
                }
                else if(list.getProduct(i) instanceof Freeze_Product){
                    String content = list.getProduct(i).getId() + "," + list.getProduct(i).getName() +
                            "," + list.getProduct(i).getPrice() + "," + list.getProduct(i).getStatus() +
                            "," + list.getProduct(i).getDescriber() + "," + ((Freeze_Product) list.getProduct(i)).getDiscount();
                    bufferedWriter.write(content);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
