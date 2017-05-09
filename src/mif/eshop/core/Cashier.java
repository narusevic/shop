package mif.eshop.core;

import java.util.Date;
import mif.eshop.io.Output;

public class Cashier extends Person
{
    public Cashier(String name)
    {
        this.id = count;
        count++;
        this.name = name;
    }

    public static void giveReceipt(Request request, int sum)
    {
        Date date = new Date();

        Receipt receipt = new Receipt(date, sum);

        Output.printReceipt(receipt);
    }
}
