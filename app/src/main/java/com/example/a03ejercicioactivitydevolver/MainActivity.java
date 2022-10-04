package com.example.a03ejercicioactivitydevolver;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03ejercicioactivitydevolver.modelos.BiciModel;
import com.example.a03ejercicioactivitydevolver.modelos.CocheModel;
import com.example.a03ejercicioactivitydevolver.modelos.MotoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Atributos vista
    private TextView lblCantidadCoches;
    private TextView lblCantidadBicis;
    private TextView lblCantidadMotos;
    private Button btnAddCoche;
    private Button btnAddMoto;
    private Button btnAddBici;
    //Atributos logica
    private ArrayList<BiciModel> listaBicis;
    private ArrayList <CocheModel> listaCoches;
    private ArrayList <MotoModel> listaMotos;
    //Atributos eventos
    private ActivityResultLauncher <Intent> crearBiciLauncher;
    private ActivityResultLauncher <Intent> crearMotoLauncher;
    private ActivityResultLauncher <Intent> crearCocheLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVariables();

        inicializaLaunchers();

        btnAddBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearBiciLauncher.launch(new Intent(MainActivity.this, CrearBiciActivity.class));
            }
        });

        btnAddCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearCocheLauncher.launch(new Intent(MainActivity.this, CrearCocheActivity.class));
            }
        });

        btnAddMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearMotoLauncher.launch(new Intent(MainActivity.this, CrearMotoActivity.class));
            }
        });
    }


    private void inicializaLaunchers() {
        inicializaLauncherBici();

        inicializaLauncherCoche();

        inicializaLauncherMoto();
    }

    private void inicializaLauncherMoto() {
        crearMotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                MotoModel moto = (MotoModel) result.getData().getExtras().getSerializable("MOTO");
                                if (moto != null) {
                                    listaMotos.add(moto);
                                    lblCantidadMotos.setText(String.valueOf(listaMotos.size()));
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "No están los datos", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Cancelada actividad coche", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void inicializaLauncherCoche() {
        crearCocheLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                CocheModel coche = (CocheModel) result.getData().getExtras().getSerializable("COCHE");
                                if (coche != null) {
                                    listaCoches.add(coche);
                                    lblCantidadCoches.setText("Coches: "+listaCoches.size());
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "No están los datos", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Cancelada actividad coche", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void inicializaLauncherBici() {
        crearBiciLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                BiciModel bici = (BiciModel) result.getData().getExtras().getSerializable("BICI");
                                if (bici != null) {
                                    listaBicis.add(bici);
                                    lblCantidadBicis.setText(String.valueOf(listaBicis.size()));
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "No están los datos", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Cancelada Actividad Bici", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void inicializaVariables() {
        lblCantidadCoches = findViewById(R.id.lblCocheMain);
        lblCantidadMotos = findViewById(R.id.lblMotoMain);
        lblCantidadBicis = findViewById(R.id.lblBiciMain);
        btnAddCoche = findViewById(R.id.btnAddCocheMain);
        btnAddMoto = findViewById(R.id.btnAddMotoMain);
        btnAddBici = findViewById(R.id.btnAddBiciMain);

        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaCoches = new ArrayList<>();
    }
}