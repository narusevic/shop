public class Request
{
    private final int id;
    private Client client;
    private Product product;
    private int amount;
    private Boolean isConfirmed;
    private Boolean hasFunds = null;
    private static int requestsCount = 0;

    public Request(Client client, Product product, int amount)
    {
        this(client, product, amount, true);
    }

    public Request(Client client, Product product, int amount, Boolean hasFunds)
    {
        this.id = this.requestsCount;  
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.hasFunds = hasFunds;
        this.requestsCount++;
    }

    public Boolean getConfirmation()
    {
        return this.isConfirmed;
    }

    public void setConfirmation(Boolean isConfirmed)
    {
        this.isConfirmed = isConfirmed;
    }

    public Boolean getHasFunds()
    {
        return this.hasFunds;
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
    public static void makeRequest(Client client, Product product)
    {
        makeRequest(client, product, 1);
    }

    public static void makeRequest(Client client, Product product, int amount)
    {     
        if (!product.isEnoughMoney(client.getMoney(), amount) || !product.enoughAmount(amount))
        {
    		String errorText = new String();

        	if (!product.isEnoughMoney(client.getMoney(), amount))
        	{
    			errorText += "Client does not have enough money. ";
        	}
        	if (!product.enoughAmount(amount))
        	{
        		errorText += "Shop does not have enough products in stock.";
        	}

        	System.out.println(errorText);
        	return;
        }

        Request newRequest = new Request(client, product, amount);

        client.subtractMoney(product.getPrice() * amount);
        product.subtractAmount(amount);   

    	System.out.println("Purchase succeeded.");
	}
}    
