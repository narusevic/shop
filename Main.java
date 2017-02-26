import java.util.*;
import java.io.*;

class Request
{
    private final int id;
    private Client client;
    private Product product;
    private int amount;
    private Boolean isConfirmed;
    private Boolean hasFunds = null;
    private static int requestsCount = 0;

    public Request(Client client, Product product, int amount)
    {
        this(client, product, amount, true);
    }

    public Request(Client newClient, Product newProduct, int newAmount, Boolean newHasFunds)
    {
        id = requestsCount;
        client = newClient;
        product = newProduct;
        amount = newAmount;
        hasFunds = newHasFunds;
        requestsCount++;
    }

    public Boolean getConfirmation()
    {
        return this.isConfirmed;
    }

    public void setConfirmation(Boolean isConfirmed)
    {
        this.isConfirmed = isConfirmed;
    }

    public Boolean getHasFunds()
    {
        return this.hasFunds;
    }

    public Client getClient()
    {
        return this.client;
    }

    public Product getProduct()
    {
        return this.product;
    }

    public int getAmount()
    {
        return this.amount;
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
        this("");
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

    public void addMoney(int addMoney)
    {
        money += addMoney;
    }

    public void subtractMoney(int subtractMoney)
    {
        money -= subtractMoney;
    }

    public int getMoney()
    {
        return this.money;
    }

    public Request makeRequest(Product product)
    {
        return makeRequest(product, 1);
    }

    public Request makeRequest(Product product, int amount)
    {        
        if (this.getMoney() >= (product.getPrice() * amount) && amount <= product.getAmount())
        {
            Request newRequest = new Request(this, product, amount);
            return newRequest;
        }
        else
        {
            Request newRequest = new Request(this, product, amount, false);
            return newRequest;
        }
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

class Shopper
{
    public static void approveRequest(Request request)
    {
        int clientMoney = request.getClient().getMoney();
        int requestAmount = request.getAmount();
        int wholeRequestPrice = requestAmount * request.getProduct().getPrice();
        int leftInShop = request.getProduct().getAmount();

        if (request.getConfirmation() == null && clientMoney >= wholeRequestPrice && requestAmount <= leftInShop)
        {
            request.setConfirmation(true);
            request.getClient().subtractMoney(request.getAmount() * request.getProduct().getPrice());
        }
        else
        {
            declineRequest(request);
        }
    }

    public static void declineRequest(Request request)
    {
        if (request.getConfirmation() == null && request.getHasFunds())
        {
            request.setConfirmation(false);
        }
    }
}

public class Main
{
    public static void main (String[] args)
    {        
        Client lukas = new Client("Lukas");
        lukas.addMoney(10);

        List<Product> availableProducts = Product.listProducts("products.txt");    

        Product product1 = new Product("Apple", 5, 100);

        Request request1 = lukas.makeRequest(product1, 1);
        Request request2 = lukas.makeRequest(product1, 2); 
        Request request3 = lukas.makeRequest(product1); 

        Shopper.approveRequest(request1);
        Shopper.approveRequest(request2);
        Shopper.approveRequest(request3);

        System.out.println(lukas.getMoney());
    }
}
