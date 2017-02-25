import java.util.*;
import java.io.*;

/*public class Request
{
}

public class Client
{
}*/

class Product
{
    private String price;
    private String name;
    private String quantity;    
    
    public static Product CreateProduct(String prName, String prPrice, String prQuantity)
    {
        Product pr = new Product();
        pr.name = prName;
        pr.price = prPrice;
        pr.quantity = prQuantity;        
        
        return pr;
    }
    
    public static List<Product> ListProducts(String file)
    {        
        List<Product> products = new ArrayList<Product>();
        
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
        
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) 
            {
                String[] productInfo = line.split(" ");
                Product newProduct = CreateProduct(productInfo[0], productInfo[1], productInfo[2]);
                products.add(newProduct);
            }
            
            String everything = sb.toString();
  
            br.close();
        }
        catch(FileNotFoundException e)
        {
            
        }
        catch(IOException e)
        {
            
        }          
          
        return products;      
    }
}

public class Shop
{
    public static void main (String[] args)
    {
        List<Product> products = Product.ListProducts("products.txt");
        System.out.println(products.get(0).name);
    }
}
