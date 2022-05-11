package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseQuantity(View view)
    {
        if(quantity >= 10){
            quantity = 10;
        } else quantity = quantity + 1;


        TextView CountText = findViewById(R.id.CountTextView);
        CountText.setText("" + quantity);
    }

    public void decreaseQuantity(View view)
    {
        if (quantity <= 0) {
            quantity = 0;
        } else quantity = quantity - 1;
        TextView CountText = findViewById(R.id.CountTextView);
        CountText.setText("" + quantity);

    }
}