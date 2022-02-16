package com.jonnym.calculatorapplab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener
{
    Button history_btn, restock_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manager);
        history_btn = findViewById(R.id.history_btn);
        restock_btn = findViewById(R.id.restock_btn);

        history_btn.setOnClickListener(this);
        restock_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //validate?
        switch (id)
        {
            case R.id.history_btn: {
                Intent intent = new Intent(this, History.class);
                startActivity(intent);
                break;
            }
            case R.id.restock_btn: {
                Intent intent = new Intent(this, Restock.class);
                startActivity(intent);
                break;
            }
        }
    }
}
