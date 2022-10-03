package com.example.a03ejercicioactivitydevolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblCoche;
    private Button btnAddCoche;

    private TextView lblMoto;
    private Button btnAddMoto;

    private TextView lblBici;
    private Button btnAddBici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVistas();
    }

    private void inicializaVistas() {
        lblCoche = findViewById(R.id.lblCocheMain);
        btnAddCoche = findViewById(R.id.btnAddCocheMain);

        lblMoto = findViewById(R.id.lblMotoMain);
        btnAddMoto = findViewById(R.id.btnAddMotoMain);

        lblBici = findViewById(R.id.lblBiciMain);
        btnAddBici = findViewById(R.id.btnAddBiciMain);
    }
}