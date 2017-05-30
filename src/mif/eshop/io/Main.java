package mif.eshop.io;

import mif.eshop.core.Product;
import mif.eshop.core.Client;
import mif.eshop.core.Request;
import mif.eshop.core.Shop;

public class Main
{
    public static void main (String[] args)
    {
       /* Client client = new Client("Client");
        client.addMoney(15);   

        Product product1 = new Product("Apple", 5, 2);
        Shop.addProduct(product1);*/
/*
        String err1 = Request.makeRequest(client, product1, 1);
        System.out.println(client.getMoney());        
        String err2 = Request.makeRequest(client, product1, 10); 
        System.out.println(client.getMoney());
        String err3 = Request.makeRequest(client, product1);  
        System.out.println(client.getMoney());  
        String err4 = Request.makeRequest(client, product1);  
        System.out.println(client.getMoney());  

        System.out.println(err1);  
        System.out.println(err2);  
        System.out.println(err3);  
        System.out.println(err4);  */

        //UserInterface.initializeUi();
        GUI.generateInterface();
    }
}
