package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int quantity = 0;
    TextView quantityTextView;
    TextView pricetext;
    ImageView goodsImageView;
    Spinner spinner;
    ArrayList spinnerArrayList = new ArrayList();
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = findViewById(R.id.TextViewQua);
        pricetext = findViewById(R.id.Price);
        goodsImageView = findViewById(R.id.TovarImage);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("pianino");
        spinnerArrayList.add("violin");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("guitar", 1000.0);
        goodsMap.put("pianino", 3000.0);
        goodsMap.put("violin", 1500.0);



    }
    public void increaseQuantity(View view) {
        quantity++;
        quantityTextView.setText("" + quantity);
        pricetext.setText("" + quantity * price);
    }

    public void decreaseQuantity(View view) {
        quantity--;
        quantity = (quantity < 0) ? (quantity = 0) : quantity;
        quantityTextView.setText("" + quantity);
        pricetext.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);

        pricetext.setText("" + quantity * price);



        if ("guitar".equals(goodsName)) {
            goodsImageView.setImageResource(R.drawable.gitara);
        } else if ("pianino".equals(goodsName)){
            goodsImageView.setImageResource(R.drawable.pianino);
        } else if ("violin".equals(goodsName)) {
            goodsImageView.setImageResource(R.drawable.violin);
        } else {
            goodsImageView.setImageResource(R.drawable.error);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}