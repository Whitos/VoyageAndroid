package com.example.voyage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextDepart;
    EditText editTextDestination;
    EditText editTextNomOption;
    EditText editTextPrixForfaitaire;
    EditText editTextNombreNuits;
    EditText editTextPrixNuit;

    Button buttonCreerKit;
    Button buttonAjouterOptions;

    KitVoyage kitVoyage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonCreerKit = findViewById(R.id.buttonValiderKit);
        editTextDepart = findViewById(R.id.editTextDepart);
        editTextDestination = findViewById(R.id.editTextDestination);
        editTextNomOption = findViewById(R.id.editTextNomOption);
        editTextPrixForfaitaire = findViewById(R.id.editTextPrixForfaitaire);
        editTextNombreNuits = findViewById(R.id.editTextNombreNuits);
        editTextPrixNuit = findViewById(R.id.editTextPrixParNuit);
        buttonAjouterOptions = findViewById(R.id.buttonAjouterOption);


        buttonCreerKit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String depart = editTextDepart.getText().toString();
                String destination = editTextDestination.getText().toString();
                kitVoyage = new KitVoyage(depart, destination);
                Log.i("kit", kitVoyage.toString());
                Toast.makeText(MainActivity.this, kitVoyage.toString(), Toast.LENGTH_LONG).show();
            }
        });

        buttonAjouterOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomOption = editTextNomOption.getText().toString();
                double prixForfaitaire = Double.parseDouble(editTextPrixForfaitaire.getText().toString());
                int nombreNuits = Integer.parseInt(editTextNombreNuits.getText().toString());
                double prixNuit = Double.parseDouble(editTextPrixNuit.getText().toString());
                Sejour sejour = new Sejour(nomOption, prixForfaitaire, nombreNuits, prixNuit);
                kitVoyage.ajouterOption(sejour);
                Log.i("kit", kitVoyage.toString());
                Toast.makeText(MainActivity.this, kitVoyage.toString(), Toast.LENGTH_LONG).show();
            }
        });




//    KitVoyage kit = new KitVoyage("Marseille","Istanbul");
//    Sejour sejour = new Sejour("Hotel 4* a Istanbul", 40, 5, 100);
//    Transport transport = new Transport("Paris-Istanbul",240);
//    kit.ajouterOption(sejour);
//    kit.ajouterOption(transport);
//
//    Log.i("kit",kit.toString());

    }
}