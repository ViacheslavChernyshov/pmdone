package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Integer quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        createMap();

    }

    public void createMap()
    {
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 1000.0);
    }

    public void createSpinner()
    {
        spinner = findViewById(R.id.Spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void increaseQuantity(View view)
    {
        if(quantity >= 10){
            quantity = 10;
        } else quantity = quantity + 1;
        TextView CountText = findViewById(R.id.CountTextView);
        CountText.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.PriceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void decreaseQuantity(View view)
    {
        if (quantity <= 0) {
            quantity = 0;
        } else quantity = quantity - 1;
        TextView CountText = findViewById(R.id.CountTextView);
        CountText.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.PriceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.PriceTextView);
        priceTextView.setText("" + quantity * price);

        ImageView goodImageView = findViewById(R.id.goodImageView);

        if(goodsName.equals("guitar")) {
            goodImageView.setImageResource(R.drawable.git);
        } else if(goodsName.equals("drums")) {
            goodImageView.setImageResource(R.drawable.drums);
        }else if(goodsName.equals("keyboard")) {
            goodImageView.setImageResource(R.drawable.piano);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}