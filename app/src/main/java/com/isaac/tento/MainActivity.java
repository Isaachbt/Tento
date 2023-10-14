package com.isaac.tento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.isaac.tento.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int pontosValendo = 1;
    private int pontosPlayer= 0;
    private int pontosAdversario = 0;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

    private void clicks()
    {
        binding.addPontosPlayer.setOnClickListener(v -> {
            pontosPlayer += pontosValendo;
            binding.pontosPlayer.setText(pontosPlayer);
        });

        binding.addPontosAdversario.setOnClickListener(v -> {
            pontosAdversario += pontosValendo;
            binding.pontosAdversario.setText(pontosAdversario);
        });
        verificarVitoria();
    }

    private void verificarVitoria()
    {

    }
}