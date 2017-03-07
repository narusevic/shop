public class Main
{
    public static void main (String[] args)
    {
        Client lukas = new Client("Lukas");
        lukas.addMoney(10);   

        Product product1 = new Product("Apple", 5, 100);

        Request request1 = lukas.makeRequest(product1, 1);
        Request request2 = lukas.makeRequest(product1, 2); 
        Request request3 = lukas.makeRequest(product1); 

        int err1 = Shopper.approveRequest(request1);
        int err2 = Shopper.approveRequest(request2);
        int err3 = Shopper.approveRequest(request2);       

        System.out.println(err1);
        System.out.println(err2);
        System.out.println(err3);
    }
}
