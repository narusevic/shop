package mif.eshop.core;

import java.util.Date;
import mif.eshop.io.Output;

public class Cashier
{
    private final int id;
    private String name;
    private static int cashiersCount;

    public Cashier(String name)
    {
        this.id = cashiersCount;
        cashiersCount++;
        this.name = name;
    }

    public static void giveReceipt(Request request, int sum)
    {
        Date date = new Date();

        Receipt receipt = new Receipt(date, sum);

        Output.printReceipt(receipt);
    }
}
