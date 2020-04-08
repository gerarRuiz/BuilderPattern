package com.example.builderpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.builderpattern.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLaunchDIalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialog customDialog = new CustomDialog("Buscar","", "Aviso", "Buscar miembro");
                customDialog.setListener(new CustomDialog.DialogButtonClickListener() {
                    @Override
                    public void onPositiveButton() {
                        Toast.makeText(MainActivity.this, "Funciona", Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.show(getSupportFragmentManager(), "Dialog1");

            }
        });
    }
}
