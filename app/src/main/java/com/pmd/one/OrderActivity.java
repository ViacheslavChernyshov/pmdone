package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {"vovabond849@gmail.com"};
    String subject = "Order from Music Shop";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent recOrderIntent = getIntent();
        String userName = recOrderIntent.getStringExtra("userName");
        String goodName = recOrderIntent.getStringExtra("goodName");
        int quantity = recOrderIntent.getIntExtra("quantity",1);
        double orderPrice = recOrderIntent.getDoubleExtra("Price", 0.0);

        emailText = "Name " + userName + "\n"+
        "GoodName " + goodName + "\n" +
                "quantity " + quantity + "\n" +
                "Price " + orderPrice;
        ;

        TextView nameTextView = findViewById(R.id.textView);
        TextView goodTextView = findViewById(R.id.textView2);
        TextView quantityTextView = findViewById(R.id.textView3);
        TextView PriceTextView = findViewById(R.id.textView4);

        nameTextView.setText("Имя: " + userName);
        goodTextView.setText("Товар: " + goodName);
        quantityTextView.setText("К-сть: " + quantity);
        PriceTextView.setText("До сплати: " + orderPrice);

    }

    public void SubmitMeth(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}