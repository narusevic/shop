package mif.eshop.core;

public class AmountException extends Exception 
{
    private int amount = 0;
    public int getAmount()
    {
        return amount;
    }

    public AmountException(String message, int amount)
    {
        super (message + " Bad Amount: " + amount);
    }
    
    public AmountException(String message)
    {
        super (message);
    }
}