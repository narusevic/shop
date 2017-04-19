package mif.eshop.io;

import java.io.PrintWriter;
import java.util.Set;

import mif.eshop.core.Product;
import mif.eshop.core.Receipt;
import mif.eshop.core.Shop;
import java.io.FileNotFoundException;
import java.io.File;

public class Output
{
    public static void printReceipt(Receipt receipt)
    {
        File receiptFile = new File("/receipt.txt");
        boolean exists = receiptFile.exists();

        if (!exists)
        {
            try{
                PrintWriter receiptOut = new PrintWriter("receipt.txt");

                receiptOut.println("Receipt number: " + receipt.getId());
                receiptOut.println("Date: " + receipt.getDate());
                receiptOut.println("Sum: " + Integer.toString(receipt.getSum()));

                receiptOut.close();
            }
            catch (FileNotFoundException e)
            {
            }
        }
    }
}    
