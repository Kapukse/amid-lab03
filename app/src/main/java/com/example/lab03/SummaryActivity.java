package com.example.lab03;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvSize = findViewById(R.id.tvSize);
        TextView tvCheese = findViewById(R.id.tvCheese);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("NAZWA_KLIENTA")) {
            String name = intent.getStringExtra("NAZWA_KLIENTA");
            String size = intent.getStringExtra("ROZMIAR");
            boolean cheese = intent.getBooleanExtra("DODATKOWY_SER", false);

            tvName.setText("Klient: " + name);
            tvSize.setText("Rozmiar pizzy: " + size);
            tvCheese.setText("Dodatkowy ser: " + (cheese ? "Tak" : "Nie"));
        }

        btnBack.setOnClickListener(v -> finish());
    }
}