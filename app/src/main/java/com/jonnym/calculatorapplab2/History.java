package com.jonnym.calculatorapplab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    ListView listView;
    ArrayList products_p;
    OrderBaseAdapter adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //switch the view
        setContentView(R.layout.activity_history);

        listView = findViewById(R.id.history);
        products_p = ((MyApp)getApplication()).orders;
        adaptor = new OrderBaseAdapter(products_p, this);
        listView.setAdapter(adaptor);

        Intent intent = new Intent(this, HistoryExpand.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("extra", Order.print((Order)products_p.get(i)));
                startActivity(intent);
            }
        });
    }

}
