package com.example.a03ejercicioactivitydevolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03ejercicioactivitydevolver.modelos.Bici;

public class BiciActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bici);

        inicializaVistas();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String pulgadas = txtPulgadas.getText().toString();

                if (!marca.isEmpty() && !pulgadas.isEmpty()){
                    Bici bici = new Bici(marca, pulgadas);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    Toast.makeText(BiciActivity.this, "Hay campos vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }

    private void inicializaVistas() {
        txtMarca = findViewById(R.id.txtMarcaBici);
        txtPulgadas = findViewById(R.id.txtPulgadasBici);
        btnCancelar = findViewById(R.id.btnCancelarBici);
        btnCrear = findViewById(R.id.btnCrearBici);

    }
}