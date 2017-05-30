package mif.eshop.core;

public class Client extends Person
{
    private int money;

    public Client()
    {
        this.id = count;
        count++;
    }

    public Client(String name)
    {
        this(name, 0);
    }

    public Client(String name, String money)
    {
    	this();
        this.name = name;

        int moneyInt = Integer.parseInt(money);
        this.money = moneyInt;
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

    public String getName()
    {
        return this.name;
    }
}
