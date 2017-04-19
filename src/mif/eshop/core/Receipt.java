package mif.eshop.core;

import java.util.Date;

public class Receipt {
    private final int id;
    private Date date;
    private int sum;    
    private static int receiptCount;    

    public Receipt(Date date, int sum)
    {
        this.id = receiptCount;
        this.date = date;
        this.sum = sum;
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