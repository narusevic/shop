class Client
{
    private final int id;
    private String name;
    private int money;
    private static int clientsCount = 0;

    public Client()
    {
        this("");
    }

    public Client(String clientName)
    {
        this(clientName, 0);
    }

    public Client(String clientName, int clientMoney)
    {
        id = clientsCount;
        name = clientName;
        money = clientMoney;
        clientsCount++;
    }

    public void addMoney(int addMoney)
    {
        money += addMoney;
    }

    public void subtractMoney(int subtractMoney)
    {
        money -= subtractMoney;
    }

    public int getMoney()
    {
        return this.money;
    }

    public Request makeRequest(Product product)
    {
        return makeRequest(product, 1);
    }

    public Request makeRequest(Product product, int amount)
    {        
        if (this.getMoney() >= (product.getPrice() * amount) && amount <= product.getAmount())
        {
            Request newRequest = new Request(this, product, amount);
            return newRequest;
        }
        else
        {
            Request newRequest = new Request(this, product, amount, false);
            return newRequest;
        }
    }
}
