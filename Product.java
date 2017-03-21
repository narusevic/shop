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

    public Product(String name, int price, int amount)
    {
    	this();
        this.name = name;
        this.price = price;
        this.amount = amount;
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

                int price = Integer.parseInt(productInfo[1]);
                int amount = Integer.parseInt(productInfo[2]);

                Product newProduct = new Product(productInfo[0], price, amount);

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

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public void subtractAmount(int amount)
    {
        this.amount -= amount;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

	public Boolean enoughAmount(int requiredAmount)
    {
    	if (requiredAmount <= this.amount)
    	{
    		return true;
    	}

    	return false;
    }

    public Boolean hasEnoughMoney(int clientMoney, int productAmount)
    {
        if (clientMoney >= productAmount * this.getPrice())
        {
            return true;
        }

        return false;
    }
}
