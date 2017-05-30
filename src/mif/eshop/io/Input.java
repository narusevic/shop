package mif.eshop.io;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import mif.eshop.core.Shop;
import mif.eshop.core.Product;
public class Input
{
    public static List<Product> readProducts(String file)
    {        
        List<Product> products = new ArrayList<Product>();
        
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
        
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) 
            {
                String[] productInfo = line.split(" ");
                if (productInfo.length != 3)
                {
                    break;
                }

                int price = Integer.parseInt(productInfo[1]);
                int amount = Integer.parseInt(productInfo[2]);

                Product newProduct = new Product(productInfo[0], price, amount);
                Shop.addProduct(newProduct);

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
}    
