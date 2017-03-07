import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Product
{
    private final int id;
    private String name;
    private int price;
    private int amount;
    private static int productsCount = 0;

    public Product()
    {
        this.id = productsCount;
        productsCount++;
    }

    public Product(String name, String price, String amount)
    {
        this(name, Integer.parseInt(price), Integer.parseInt(amount));
    }

    public Product(String name, int price, int amount)
    {
        this.id = this.productsCount;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.productsCount++;
    }
    
    public static List<Product> listProducts(String file)
    {        
        List<Product> products = new ArrayList<Product>();
        
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
        
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) 
            {
                System.out.println(line);
                String[] productInfo = line.split(" ");
                if (productInfo.length != 3)
                {
                    break;
                }
                Product newProduct = new Product(productInfo[0], productInfo[1], productInfo[2]);

                products.add(newProduct);
                line = reader.readLine();
            }
            
            String everything = builder.toString();
  
            reader.close();
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
