package com.jonnym.calculatorapplab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Restock extends AppCompatActivity implements View.OnClickListener
{
    ArrayList<Product> listOfProducts;
    Button okay_btn, cancel_btn;
    EditText editText;
    ListView listView;
    ProductBaseAdapter productBaseAdaptor;
    Product product;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        //restock view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        okay_btn = findViewById(R.id.okay_btn);
        cancel_btn = findViewById(R.id.cancel_btn);
        editText = findViewById(R.id.newQuantity);
        listView = findViewById(R.id.newItems);
        productBaseAdaptor = new ProductBaseAdapter(listOfProducts, this);

        listOfProducts = ((MyApp) getApplication()).productArrayList;

        okay_btn.setOnClickListener(this);
        cancel_btn.setOnClickListener(this);
        listView.setAdapter(productBaseAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                product = listOfProducts.get(i);
            }
        });

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.okay_btn: {
                if(editText.getText().toString().isEmpty())
                {
                    product.productQty += Integer.parseInt(editText.getText().toString());
                    productBaseAdaptor = new ProductBaseAdapter(listOfProducts, this);
                    listView.setAdapter(productBaseAdaptor);
                }
                break;
            }
            case R.id.cancel_btn:
                {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }
}
