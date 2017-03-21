public class Request
{
    private final int id;
    private Client client;
    private Product product;
    private int amount;
    private static int requestsCount = 0;

    public Request(Client client, Product product, int amount)
    {
        this.id = this.requestsCount;  
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.requestsCount++;
    }

    public Client getClient()
    {
        return this.client;
    }

    public Product getProduct()
    {
        return this.product;
    }

    public int getAmount()  
    {
        return this.amount;
    }
    public static String makeRequest(Client client, Product product)
    {
        return makeRequest(client, product, 1);
    }

    public static String makeRequest(Client client, Product product, int amount)
    {     
        if (!product.hasEnoughMoney(client.getMoney(), amount) || !product.enoughAmount(amount))
        {
    		String errorText = new String();

        	if (!product.hasEnoughMoney(client.getMoney(), amount))
        	{
    			errorText += "Client does not have enough money. ";
        	}
        	if (!product.enoughAmount(amount))
        	{
        		errorText += "Shop does not have enough products in stock.";
        	}

        	return errorText;
        }

        Request newRequest = new Request(client, product, amount);

        client.subtractMoney(product.getPrice() * amount);
        product.subtractAmount(amount);   

    	return "Request succeeded!";
	}
}    
