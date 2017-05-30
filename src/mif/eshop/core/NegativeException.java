package mif.eshop.core;

public class NegativeException extends Exception 
{
    private int amount = 0;
    public int getAmount()
    {
        return amount;
    }

    public NegativeException(String message, int amount)
    {
        super (message + " Bad Amount: " + amount);
    }
    
    public NegativeException(String message)
    {
        super (message);
    }
}