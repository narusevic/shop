import java.util.*;
import java.io.*;

class Product
{
    private final int id;
    private String name;
    private int price;
    private int amount;
    private static int productsCount = 0;

    public Product()
    {
        this("", 0, 0);       
    }

    public Product(String productName, int productPrice, int productAmount)
    {
        id = productsCount;
        name = productName;
        price = productPrice;
        amount = productAmount;
        productsCount++;
    }

    public Product(String productName, String productPrice, String productAmount)
    {
        id = productsCount;
        productsCount++;
        name = productName;
        price = Integer.parseInt(productPrice);
        amount = Integer.parseInt(productAmount);
    }
    
    public static List<Product> listProducts(String file)
    {        
        List<Product> products = new ArrayList<Product>();
        
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
        
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null ) 
            {
                System.out.println(line);
                String[] productInfo = line.split(" ");
                if (productInfo.length != 3)
                {
                    break;
                }
                Product newProduct = new Product(productInfo[0], productInfo[1], productInfo[2]);

                products.add(newProduct);
                line = br.readLine();
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

    public int getPrice()
    {
        return this.price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getAmount()
    {
        return this.amount;
    }

    public void setAmount(int price)
    {
        this.amount = amount;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
