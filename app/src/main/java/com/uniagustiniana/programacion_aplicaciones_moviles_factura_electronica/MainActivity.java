package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(this::setup);
    }

    protected void setup(View view) {
        EditText userName = findViewById(R.id.etName);
        EditText userLastname = findViewById(R.id.etLastname);

        UserDTO user = new UserDTO();
        user.setName(userName.getText().toString());
        user.setLastname(userLastname.getText().toString());

        Intent intent = new Intent(this, InvoicingActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}