package com.jonnym.calculatorapplab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {

    ArrayList<Product> listOfProducts;
    Context context;

    public ProductBaseAdapter(ArrayList<Product> listOfProducts, Context context) {
        this.listOfProducts = listOfProducts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOfProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.product_row,null);

        TextView product_name = view.findViewById(R.id.row1);
        TextView product_quantity = view.findViewById(R.id.row2);


        product_name.setText(listOfProducts.get(i).productName + "\n" + listOfProducts.get(i).price);
        product_quantity.setText(Integer.toString(listOfProducts.get(i).productQty) + "\n");
        return view;
    }
}
