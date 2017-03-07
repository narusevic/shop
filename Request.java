class Request
{
    private final int id;
    private Client client;
    private Product product;
    private int amount;
    private Boolean isConfirmed;
    private Boolean hasFunds = null;
    private static int requestsCount = 0;

    public Request(Client newClient, Product newProduct, int newAmount)
    {
        this(newClient, newProduct, newAmount, true);
    }

    public Request(Client newClient, Product newProduct, int newAmount, Boolean newHasFunds)
    {
        id = requestsCount;  
        client = newClient;
        product = newProduct;
        amount = newAmount;
        hasFunds = newHasFunds;
        requestsCount++;
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
}    

