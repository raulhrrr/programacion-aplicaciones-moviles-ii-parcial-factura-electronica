package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InvoicingActivity extends AppCompatActivity {

    private final Map<String, BigDecimal> products = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoicing);

        products.put("tomato", new BigDecimal("1000"));
        products.put("onion", new BigDecimal("2000"));

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(v -> {
            EditText qtTomato = findViewById(R.id.qtTomato);
            EditText qtOnion = findViewById(R.id.qtOnion);

            BigDecimal qtTomatoNumber = new BigDecimal(qtTomato.getText().toString());
            BigDecimal qtOnionNumber = new BigDecimal(qtOnion.getText().toString());

            TextView total = findViewById(R.id.total);
            total.setText(qtTomatoNumber.multiply(products.get("Tomato")).toString());
        });
    }
}