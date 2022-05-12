
package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {"deadbox33@gmail.com"};
    String subject = "Order from Music Shop";
    TextView orderTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderTextView = findViewById(R.id.orderTextView);

        Intent receivedOrderIntent = getIntent();
        Order order;
        if (receivedOrderIntent != null) {
            order = (Order) receivedOrderIntent.getSerializableExtra(Order.class.getSimpleName());
            orderTextView.setText("Customer name: " + order.getUserName() + "\n" +
                    "Goods name: " + order.getGoodsName() + "\n" +
                    "Quantity: " + order.getQuantity() + "\n" +
                    "Price: " + order.getPrice() + "\n" +
                    "Order price: " + order.getOrderPrice());
        }
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, orderTextView.getText());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
