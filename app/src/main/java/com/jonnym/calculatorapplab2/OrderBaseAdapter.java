package com.jonnym.calculatorapplab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderBaseAdapter extends BaseAdapter {
    ArrayList<Order> purchaseList;
    Context context;

    public OrderBaseAdapter(ArrayList<Order> purchaseList, Context context) {
        this.purchaseList = purchaseList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return purchaseList.size();
    }

    @Override
    public Object getItem(int i) {
        return purchaseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.product_row,null);


        TextView purchase_name = view.findViewById(R.id.row1);
        TextView purchase_price = view.findViewById(R.id.row2);
        //ImageView img = view.findViewById(R.id.donation_img);

        purchase_name.setText(purchaseList.get(i).productName + "\n" + purchaseList.get(i).productPurchased);
        purchase_price.setText(Double.toString(purchaseList.get(i).price) + "\n");


        //img.setImageResource(R.drawable.inmg)
        return view;
    }

}
