public class Main
{
    public static void main (String[] args)
    {
        Client client = new Client("Client");
        client.addMoney(15);   

        Product product1 = new Product("Apple", 5, 2);

        Request.makeRequest(client, product1, 1);
        System.out.println(client.getMoney());        
        Request.makeRequest(client, product1, 10); 
        System.out.println(client.getMoney());
        Request.makeRequest(client, product1);  
        System.out.println(client.getMoney());  
        Request.makeRequest(client, product1);  
        System.out.println(client.getMoney());  
    }
}
