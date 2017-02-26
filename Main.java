import java.util.*;
import java.io.*;

class Request
{
    private final int id;
    private Client client;
    private Product product;
    private int amount;
    private Boolean isConfirmed = null;
    private static int requestsCount = 0;

    public Request(Client client, Product product, int amount)
    {
        id = requestsCount;
        client = client;
        product = product;
        amount = amount;
        requestsCount++;
    }
}    

class Client
{
    private final int id;
    private String name;
    private int money;
    private static int clientsCount = 0;

    public Client()
    {
        this("", 0);
    }

    public Client(String clientName)
    {
        this(clientName, 0);
    }

    public Client(String clientName, int clientMoney)
    {
        id = clientsCount;
        name = clientName;
        money = clientMoney;
        clientsCount++;
    }

    public int MakeRequest(Product product, int amount)
    {
        Request request = new Request(this, product, amount);
        return 1;
    }
}

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

    public int SoldProduct(int amount)
    {
        if (this.amount >= amount)
        {
            this.amount -= amount;

            return 1;
        }

        return 0;
    }
    
    public static List<Product> ListProducts(String file)
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
}

public class Main
{
    public static void main (String[] args)
    {        
        List<Product> products = Product.ListProducts("products.txt");

        Product p = products.get(0);
        //System.out.println(p.name);
    }
}
