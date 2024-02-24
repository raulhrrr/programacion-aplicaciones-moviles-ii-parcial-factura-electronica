package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

public class InvoicingActivity extends AppCompatActivity {

    private final CalculateInvoicing calculateInvoicing = new CalculateInvoicing();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoicing);

        TextView cuTomato = findViewById(R.id.cuTomato);
        TextView cuOnion = findViewById(R.id.cuOnion);

        cuTomato.setText(String.format(CalculateInvoicing.MESSAGE, calculateInvoicing.getProducts().get("tomato")));
        cuOnion.setText(String.format(CalculateInvoicing.MESSAGE, calculateInvoicing.getProducts().get("onion")));

        Intent intent = getIntent();
        UserDTO user = (UserDTO) Objects.requireNonNull(intent.getSerializableExtra("user"));
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText(
                String.format(
                        Locale.getDefault(),
                        "Bienvenido(a) %s",
                        user.getFullName()
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
                        "$ %s",
                        calculateInvoicing.calculateTotal(qtTomatoNumber, qtOnionNumber)
                ));
    }
}