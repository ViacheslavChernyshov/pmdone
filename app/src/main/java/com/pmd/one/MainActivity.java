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
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int quantity = 0;
    TextView quantityTextView;
    TextView pricetext;
    ImageView goodsImageView;
    Spinner spinner;
    ArrayList spinnerArrayList = new ArrayList();
    ArrayAdapter spinnerAdapter;
    EditText UserName_EditText;

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
        UserName_EditText = findViewById(R.id.UserName);

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
            goodsImageView.setImageResource(R.drawable.guitar);
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
    public void addToCard(View view) {
        Order order = new Order(UserName_EditText.getText().toString(),
                goodsName,
                quantity,
                price,
                quantity * price);
        Intent orderIntent = new Intent(MainActivity.this, Order_Activity.class);
        orderIntent.putExtra(Order.class.getSimpleName(), order);
        startActivity(orderIntent);
    }
}