package com.example.a03ejercicioactivitydevolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a03ejercicioactivitydevolver.modelos.CocheModel;

public class CrearCocheActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCrear;
    private Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);

        inicializaVistas();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if (!marca.isEmpty() && !modelo.isEmpty() && !color.isEmpty()){
                    CocheModel coche = new CocheModel(marca, modelo, color);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(CrearCocheActivity.this, "Hay campos vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

    private void inicializaVistas() {
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);

        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnCrear = findViewById(R.id.btnCrearCoche);
    }
}