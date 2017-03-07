public class Client
{
    private final int id;
    private String name;
    private int money;
    private static int clientsCount = 0;

    public Client()
    {
        this.id = clientsCount;
        clientsCount++;
    }

    public Client(String name)
    {
        this(name, 0);
    }

    public Client(String name, int money)
    {
        this.id = this.clientsCount;
        this.name = name;
        this.money = money;
        this.clientsCount++;
    }

    public void addMoney(int addMoney)
    {
        this.money += addMoney;
    }

    public void subtractMoney(int subtractMoney)
    {
        this.money -= subtractMoney;
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
