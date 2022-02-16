package com.jonnym.calculatorapplab2;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application
{
    ArrayList<Product> productArrayList = new ArrayList<Product>()
    {
        {
            add(new Product(10, "Pants", 20.44));
            add(new Product(100, "Shoes", 10.44));
            add(new Product(30, "Hats", 5.90));
        }

        //productArrayList.add(10, "Pants", 20.44)
    };
    ArrayList<Order> orders = new ArrayList<Order>(0);
}

