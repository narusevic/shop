package mif.eshop.io;

import java.io.Console;
import mif.eshop.core.Product;
import mif.eshop.core.Client;
import mif.eshop.core.Shop;
import mif.eshop.core.Request;
import java.util.List;
public class UserInterface{
    public static void initializeUi()
    {
        Console console = System.console();
                
        inputName(console);
    }

    public static void buyProduct(Console console, Client client)
    {
        String productIdString = console.readLine("Input product id\n");

        int productId = Integer.parseInt(productIdString);
    
        Product product = Shop.getProductById(productId);

        String amountString = console.readLine("Input amount\n");
        
        int amount = Integer.parseInt(amountString);

        String err1 = Request.makeRequest(client, product, amount);
        console.printf(err1);
    }
    public static void selectOption(Console console, Client client)
    {
        String optionNumberString = console.readLine("\nSelect option: \n1. List all products \n2. Buy product\n");

        int optionNumber = Integer.parseInt(optionNumberString);

        if (optionNumber == 1)
        {
            List<Product> products = Product.listProducts();
            for (int i = 0; i < products.size(); i++)
            {                
                console.printf("Product " + products.get(i).getName() + " amount: " + products.get(i).getAmount() + " price: " + products.get(i).getPrice() + "\n");
            }
            selectOption(console, client);
        }
        else if (optionNumber == 2)
        {
            buyProduct(console, client);
            selectOption(console, client);
        }
        else
        {
            console.printf("Wrong parameter\n");
            selectOption(console, client);
        }
    }

    public static void inputName(Console console)
    {
        String clientName = console.readLine("Input name\n");
        
        Client client = new Client(clientName);
        
        String moneyString = console.readLine("How much money do you have?\n");
        int money = Integer.parseInt(moneyString);
        client.addMoney(money); 

        selectOption(console, client);        
    }
}