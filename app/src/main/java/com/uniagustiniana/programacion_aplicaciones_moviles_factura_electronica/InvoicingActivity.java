package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class InvoicingActivity extends AppCompatActivity {

    private final Map<String, BigDecimal> products = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoicing);

        products.put("tomato", new BigDecimal("1000"));
        products.put("onion", new BigDecimal("2000"));

        Intent intent = getIntent();
        UserDTO user = (UserDTO) Objects.requireNonNull(intent.getSerializableExtra("user"));
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText(
                String.format(
                        Locale.getDefault(),
                        "Bienvenido(a) %s %s",
                        user.getName(),
                        user.getLastname()
                ));

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this::setup);
    }

    protected void setup(View view) {
        EditText qtTomato = findViewById(R.id.qtTomato);
        EditText qtOnion = findViewById(R.id.qtOnion);

        BigDecimal qtTomatoNumber = new BigDecimal(qtTomato.getText().toString());
        BigDecimal qtOnionNumber = new BigDecimal(qtOnion.getText().toString());

        TextView total = findViewById(R.id.total);
        total.setText(
                String.format(
                        Locale.getDefault(),
                        "$ %s", qtTomatoNumber.multiply(products.get("tomato"))
                        .add(qtOnionNumber.multiply(products.get("onion")))
                )
        );
    }
}