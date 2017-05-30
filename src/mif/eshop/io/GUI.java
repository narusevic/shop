package mif.eshop.io;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import mif.eshop.core.Client;
import mif.eshop.core.Product;
import mif.eshop.core.Request;
import mif.eshop.core.Shop;
import mif.eshop.core.AmountException;

public class GUI
{
    public static void generateInterface()
    {

        GUI.userWelcome();
    }

    public static void userWelcome()
    {
        JFrame welcomeFrame = new JFrame();
        welcomeFrame.setSize(220, 300);

        JLabel inputNameLabel = new JLabel("Input your name:");
        JLabel inputMoneyLabel = new JLabel("Input money you have:");
        JTextArea exceptionArea = new JTextArea("No Exceptions");
        JTextField userNameField = new JTextField();
        JTextField userMoneyField = new JTextField("0");
        JButton confirmPersonButton = new JButton("Confirm");

        exceptionArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(exceptionArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        confirmPersonButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String userName = userNameField.getText();
                String userMoney = userMoneyField.getText();

                try 
                {
                    Client newClient = new Client(userName, userMoney);

                    welcomeFrame.setVisible(false);

                    generateShopWindow(newClient);

                    return;
                }
                catch (NumberFormatException exception)
                {
                    exceptionArea.setText(exception.toString());
                    welcomeFrame.add(scroll);
                }
            }
        });

        inputNameLabel.setBounds(20, 20, 160,20);
        inputMoneyLabel.setBounds(20, 80, 160, 20);
        userNameField.setBounds(20, 50, 160, 20);
        userMoneyField.setBounds(20, 110, 160, 20);
        confirmPersonButton.setBounds(50, 140, 80, 30);
        exceptionArea.setBounds(20, 180, 160, 30);

        welcomeFrame.add(inputNameLabel);
        welcomeFrame.add(inputMoneyLabel);
        welcomeFrame.add(userNameField);
        welcomeFrame.add(userMoneyField);
        welcomeFrame.add(confirmPersonButton);
        welcomeFrame.add(scroll);
        welcomeFrame.add(exceptionArea);

        welcomeFrame.setLayout(null);
        welcomeFrame.setVisible(true);
    }

    public static void generateShopWindow(Client client)
    {
        JFrame shopFrame = new JFrame();
        shopFrame.setSize(600, 300);

        JLabel nameLabel = new JLabel(client.getName());
        JLabel moneyLabel = new JLabel(Integer.toString(client.getMoney()) + "eu");
        JLabel selectProductLabel = new JLabel("Select product:");
        JLabel amountLabel = new JLabel("Enter amount:");
        JTextField amountField = new JTextField("0");
        JButton buyButton = new JButton("Buy");
        JTextArea exceptionArea = new JTextArea("No Exceptions");

        List<Product> products = Input.readProducts("products.txt");

        DefaultListModel<String> productNames = new DefaultListModel<>();
        int[] productIds = new int[products.size()];
        
        for (int i = 0; i < products.size(); i++) 
        {             
            productNames.addElement(products.get(i).getName() + " " + products.get(i).getPrice() + "eu");
            productIds[i] = products.get(i).getId();
        }    

        final JList<String> productsMenu = new JList<>(productNames);
        productsMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productsMenu.setVisibleRowCount(8);

        buyButton.addActionListener(new ActionListener()
        {     
            public void actionPerformed(ActionEvent e)
            {
                int amount;

                try 
                {
                    amount = Integer.parseInt(amountField.getText());

                    if (amount < 0)
                    {
                        throw new AmountException("Amount can't be below 0.", amount);
                    }
                    else if (amount == 0)
                    {
                        throw new AmountException("Amount can't be 0.");
                    }
                }
                catch (NumberFormatException exception)
                {
                    exceptionArea.setText(exception.toString());
                    //shopFrame.add(scroll);

                    return;
                }
                catch (AmountException exception)
                {                    
                    exceptionArea.setText(exception.toString());

                    return;
                }

                int listIndex = productsMenu.getSelectedIndex();
                int productId = productIds[listIndex];

                System.out.println("atejo");  

                Product selectedProduct = Shop.getProductById(productId);

                String err1 = Request.makeRequest(client, selectedProduct, amount);

                exceptionArea.setText(err1);

                moneyLabel.setText((client.getMoney()) + "eu");
            }
        });

        nameLabel.setBounds(20, 20, 60, 20);
        moneyLabel.setBounds(120, 20, 60, 20);
        selectProductLabel.setBounds(240, 20, 100, 20);
        productsMenu.setBounds(240, 50, 100, 150);
        amountLabel.setBounds(20, 60, 100, 20);
        amountField.setBounds(20, 90, 100, 20);
        buyButton.setBounds(20, 140, 200, 30);
        exceptionArea.setBounds(20, 220, 500, 30);

        shopFrame.add(nameLabel);
        shopFrame.add(moneyLabel);
        shopFrame.add(selectProductLabel);
        shopFrame.add(amountLabel);
        shopFrame.add(amountField);
        shopFrame.add(buyButton);
        shopFrame.add(exceptionArea);
        shopFrame.add(productsMenu);
        
        shopFrame.setLayout(null);
        shopFrame.setVisible(true);
    }
}