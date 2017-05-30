package mif.eshop.core;

import java.util.Date;

public class Receipt extends Service
{
    private final int id;
    private Date date;
    private int sum;    
    private static int receiptCount = 0;    

    public Receipt(Date date, int sum)
    {
        this.id = receiptCount;
        this.date = date;
        this.sum = sum;
        this.receiptCount++;
    }

    public int countTaxes(int sum)
    {
        return sum + 2;
    }

    public int getId()
    {
        return this.id;
    }

    public Date getDate()
    {
        return this.date;
    }

    public int getSum()
    {
        return this.sum;
    }
}