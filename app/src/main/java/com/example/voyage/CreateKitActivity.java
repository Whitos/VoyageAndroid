package com.example.voyage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.voyage.databinding.ActivityMainKitBinding;


public class CreateKitActivity extends AppCompatActivity {

    private ActivityMainKitBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainKitBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String depart = binding.editTextDepart.getText().toString();
                String arrivee = binding.editTextArrivee.getText().toString();
                KitVoyage kitVoyage = new KitVoyage(depart, arrivee);

                Intent intent = new Intent(CreateKitActivity.this, CreateOptionsActivity.class);
                intent.putExtra("KitVoyage", kitVoyage);

                startActivity(intent);
            }
        });
    }
}