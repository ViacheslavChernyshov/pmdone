package com.pmd.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openMarket(View view) {
        Intent intent = new Intent(MainActivity.this, Market.class);
        startActivity(intent);
    }

    public void openAnimation(View view) {
        Intent intent = new Intent(MainActivity.this, Animation.class);
        startActivity(intent);
    }

    public void openVideo(View view) {
        Intent intent = new Intent(MainActivity.this, Video.class);
        startActivity(intent);
    }

    public void openAudio(View view) {
        Intent intent = new Intent(MainActivity.this, Audio.class);
        startActivity(intent);
    }
}
