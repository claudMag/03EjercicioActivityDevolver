package com.example.a03ejercicioactivitydevolver;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03ejercicioactivitydevolver.modelos.Bici;

public class MainActivity extends AppCompatActivity {

    private TextView lblCoche;
    private Button btnAddCoche;

    private TextView lblMoto;
    private Button btnAddMoto;

    private TextView lblBici;
    private Button btnAddBici;

    private static int contadorBici = 0;
    private static int contadorCoche = 0;

    private ActivityResultLauncher <Intent> launcherBici;
    private ActivityResultLauncher <Intent> launcherMoto;
    private ActivityResultLauncher <Intent> launcherCoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVistas();

        lblBici.setText(String.valueOf(contadorBici));
        lblCoche.setText(String.valueOf(contadorCoche));

        inicializaLaunchers();

        btnAddBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BiciActivity.class);
                launcherBici.launch(intent);
            }
        });

        btnAddCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CocheActivity.class);
                launcherCoche.launch(intent);
            }
        });
    }

    private void inicializaLaunchers() {
        inicializaLauncherBici();

        inicializaLauncherCoche();
    }

    private void inicializaLauncherCoche() {
        launcherCoche = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null){
                                contadorCoche++;
                                lblCoche.setText(String.valueOf(contadorCoche));
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Cancelada actividad coche", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void inicializaLauncherBici() {
        launcherBici = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null){
                                //Bundle bundle = result.getData().getExtras();
                                //Bici bici = (Bici) bundle.getSerializable("BICI");
                                contadorBici++;
                                lblBici.setText(String.valueOf(contadorBici));
                            }
                        }
                        else if (result.getResultCode() == RESULT_CANCELED){
                            Toast.makeText(MainActivity.this, "Cancelada Actividad Bici", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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