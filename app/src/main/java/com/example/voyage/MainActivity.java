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
    Button buttonCreerKit;

    KitVoyage kitVoyage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonCreerKit = findViewById(R.id.buttonValiderKit);
        editTextDepart = findViewById(R.id.editTextDepart);
        editTextDestination = findViewById(R.id.editTextDestination);

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


//    KitVoyage kit = new KitVoyage("Marseille","Istanbul");
//    Sejour sejour = new Sejour("Hotel 4* a Istanbul", 40, 5, 100);
//    Transport transport = new Transport("Paris-Istanbul",240);
//    kit.ajouterOption(sejour);
//    kit.ajouterOption(transport);
//
//    Log.i("kit",kit.toString());

    }
}