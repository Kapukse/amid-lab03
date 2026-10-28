package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        RadioGroup rgSize = findViewById(R.id.rgSize);
        CheckBox cbCheese = findViewById(R.id.cbCheese);
        Button btnSummary = findViewById(R.id.btnSummary);

        btnSummary.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();

            if (name.isEmpty()) {
                etName.setError("Wpisz nazwę klienta");
                return;
            }

            String size = "Mała";
            int checkedId = rgSize.getCheckedRadioButtonId();
            if (checkedId == R.id.rbMedium) {
                size = "Średnia";
            } else if (checkedId == R.id.rbLarge) {
                size = "Duża";
            }

            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
            intent.putExtra("NAZWA_KLIENTA", name);
            intent.putExtra("ROZMIAR", size);
            intent.putExtra("DODATKOWY_SER", cbCheese.isChecked());
            startActivity(intent);
        });
    }
}