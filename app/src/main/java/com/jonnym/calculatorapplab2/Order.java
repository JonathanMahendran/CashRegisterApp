package com.jonnym.calculatorapplab2;

import java.util.Date;

public class Order {
    // int string double date?
    int productPurchased;
    String productName;
    double price;

    Date date;

    public Order()
    {
        this(0, null,0,null);
    }

    public Order(int productPurchased, String productName, double price, Date date) {
        this.productPurchased = productPurchased;
        this.productName = productName;
        this.price = price;
        this.date = date;
    }

    public static String print(Order order)
    {
        return ("Product: " + order.productName +
                "\n" + "Price: " + order.price +
                "\n" + "Purchase Date: " + order.date);
    }
}
