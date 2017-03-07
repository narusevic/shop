class Request
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
}    
