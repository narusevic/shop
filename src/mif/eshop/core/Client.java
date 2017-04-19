package mif.eshop.core;

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
    	this();
        this.name = name;
        this.money = money;
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
}
