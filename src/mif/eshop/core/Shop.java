package mif.eshop.core;

import java.util.List;
import java.util.ArrayList;

public class Shop
{
    private static List<Product> products = new ArrayList<Product>(){};

    public Shop(){}

    public static Boolean addProduct(Product product)
    {
        if(products.contains(product))
        {
            return false;
        }
        else
        {            
            products.add(product);
            return true;
        }
    }

    public static List<Product> getProducts()
    {
        return products;
    }

    public static Product getProductById(int productId)
    {
        return products.get(productId);
    }
}