package com.example.a03ejercicioactivitydevolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a03ejercicioactivitydevolver.modelos.MotoModel;

public class CrearMotoActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCC;
    private Button btnCrear;
    private Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);

        inicializaVistas();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String cc = txtCC.getText().toString();

                if (!marca.isEmpty() && !modelo.isEmpty() && !cc.isEmpty()){
                    MotoModel moto = new MotoModel(marca, modelo, Integer.parseInt(cc));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO", moto);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
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

        txtMarca = findViewById(R.id.txtMarcaMoto);
        txtModelo = findViewById(R.id.txtModeloMoto);
        txtCC = findViewById(R.id.txtCCMoto);
        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrear = findViewById(R.id.btnCrearMoto);
    }
}