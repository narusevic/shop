package mif.eshop.core;

public abstract class Service
{
    int sum;  

    public abstract int countTaxes(int sum);

    public int getSum()
    {
        return this.sum;
    }

    public void setSum(int sum)
    {
        this.sum = sum;
    }
} 