package com.jonnym.calculatorapplab2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button manager_btn, buy_btn;
    NumberPicker numberPicker;
    TextView total, quantity, productView;
    ListView listView;
    ArrayList<Product> productArrayList;
    AlertDialog.Builder builder;
    ProductBaseAdapter adaptor;
    Product product;
    double price;
    int user_quantity;

    private static final DecimalFormat decimalFormat= new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager_btn = findViewById(R.id.manager_btn);
        buy_btn = findViewById(R.id.buy_btn);
        numberPicker = findViewById(R.id.numberPicker);
        productView = findViewById(R.id.product);
        total = findViewById(R.id.total);
        quantity = findViewById(R.id.quantity);
        listView = findViewById(R.id.row1);
        builder = new AlertDialog.Builder(this);
        buy_btn.setOnClickListener(this);
        manager_btn.setOnClickListener(this);

        // 1) return application object 2) adapater 3) list
        productArrayList = ((MyApp)getApplication()).productArrayList;
        adaptor = new ProductBaseAdapter(productArrayList, this);
        listView.setAdapter(adaptor);

        //number picker values
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                user_quantity = numberPicker.getValue();
                Log.d("picker value", user_quantity + " ");

                //keep reset messages
                if(user_quantity == 0)
                {
                    quantity.setText(R.string.quantity);
                    total.setText(R.string.total);
                }else {
                    quantity.setText(Integer.toString(user_quantity));
                }
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                product = productArrayList.get(i);
                productView.setText(product.productName);

                if(user_quantity > product.productQty)
                {
                    Toast.makeText(MainActivity.this, "Not enough quantity in the stock!!!", Toast.LENGTH_SHORT).show();
                }else
                {
                    price = Double.parseDouble(decimalFormat.format(user_quantity * product.price));
                    total.setText(Double.toString(price));
                }
            }
        });



    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {

            case R.id.buy_btn: {
                product.productQty -= user_quantity;
                Order order = new Order(user_quantity, product.productName, price, new Date());
                ((MyApp)getApplication()).orders.add(order);
                adaptor = new ProductBaseAdapter(productArrayList, this);
                listView.setAdapter(adaptor);

                if(user_quantity == 0 || product == null)
                {
                    Toast.makeText(this, "All fields are required!!!", Toast.LENGTH_LONG).show();
                } else if(product.productQty < user_quantity)
                {
                    Toast.makeText(this, "Not enough quantity in the stock!!!", Toast.LENGTH_LONG).show();
                }else if(user_quantity != 0 && product!= null && product.productQty > user_quantity)
                {

                    builder.setTitle("Thank You for your purchase");
                    builder.setMessage("Your purchase is " + order.productPurchased + " " + order.productName + " for " +  order.price);
                    builder.show();
                }

                productView.setText(R.string.product);
                quantity.setText(R.string.quantity);
                total.setText(R.string.total);

                break;

            } case R.id.manager_btn:
                {
                Intent intent = new Intent(this, ManagerActivity.class);
                startActivity(intent);
                break;
            } default:
                Toast.makeText(this, "Nothing Selected", Toast.LENGTH_LONG).show();
        }
    }
}