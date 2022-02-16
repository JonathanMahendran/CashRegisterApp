package com.jonnym.calculatorapplab2;

public class Product {
    //int string double
    int productQty;
    String productName;
    double price;

    public Product()
    {
        this(0," ",0.00);
    }

    public Product(int productQty, String productName, double price) {
        this.productQty = productQty;
        this.productName = productName;
        this.price = price;
    }

}
