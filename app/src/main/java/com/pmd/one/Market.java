package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Market extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    TextView quantityTextView;
    ImageView goodsImageView;
    EditText userNameEditText;
    Spinner spinner;
    ArrayList spinnerArrayList = new ArrayList();
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        userNameEditText = findViewById(R.id.nameEditText);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 500.0);

    }

    public void increaseQuantity(View view) {
        quantity++;
        quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void decreaseQuantity(View view) {
        quantity--;
        quantity = (quantity < 0) ? (quantity = 0) : quantity;
        quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

        goodsImageView = findViewById(R.id.goodsImageView);

        if ("guitar".equals(goodsName)) {
            goodsImageView.setImageResource(R.drawable.guitar);
        } else if ("drums".equals(goodsName)){
            goodsImageView.setImageResource(R.drawable.drum);
        } else if ("keyboard".equals(goodsName)) {
            goodsImageView.setImageResource(R.drawable.keyboard);
        } else {
            goodsImageView.setImageResource(R.drawable.problem);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCard(View view) {
        Order order = new Order(userNameEditText.getText().toString(),
                goodsName,
                quantity,
                price,
                quantity * price);
        Intent orderIntent = new Intent(Market.this, OrderActivity.class);
        orderIntent.putExtra(Order.class.getSimpleName(), order);
        startActivity(orderIntent);
    }
}
