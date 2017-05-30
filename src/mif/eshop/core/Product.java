package mif.eshop.core;

import java.util.List;

public class Product implements Commodity
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
        
    public int getPrice()
    {
        return this.price;
    }
        
    public int getId()
    {
        return this.id;
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

    public static List<Product> listProducts()
    {
        List<Product> products = Shop.getProducts();

        return products;
    }
}
