package com.isaac.tento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.isaac.tento.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int pontosValendo = 1;
    private int pontosPlayer= 0;
    private int pontosAdversario = 0;
    private int pontosMaximoVitoria = 12;//isso aqui vai mudar, vou usar  shared
    private int totalVitoriasPlayer = 0;
    private int totalVitoriasAdversario = 0;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addPontos();
        removePontos();

    }

    private void removePontos()
    {
        binding.diminuirPontosPlayer.setOnClickListener(v -> {
            pontosPlayer -= 1;
            atualizarValoresTela();
        });

        binding.diminuirPontosAdversario.setOnClickListener(v -> {
            pontosAdversario -= 1;
            atualizarValoresTela();
        });
    }

    private void addPontos()
    {
        binding.addPontosPlayer.setOnClickListener(v -> {
            pontosPlayer += pontosValendo;
            atualizarValoresTela();
            verificarVitoria();
        });

        binding.addPontosAdversario.setOnClickListener(v -> {
            pontosAdversario += pontosValendo;
            atualizarValoresTela();
            verificarVitoria();
        });


    }

    private void verificarVitoria()
    {
        if (pontosPlayer >= pontosMaximoVitoria) {
            totalVitoriasPlayer += 1;
            pontosAdversario = 0;
            pontosPlayer = 0;
        } else if (pontosAdversario >= pontosMaximoVitoria) {
            totalVitoriasAdversario += 1;
            pontosAdversario = 0;
            pontosPlayer = 0;
        }
        atualizarValoresTela();
    }

    private void  atualizarValoresTela()
    {
        binding.pontosPlayer.setText(String.valueOf(pontosPlayer));
        binding.pontosAdversario.setText(String.valueOf(pontosAdversario));
        binding.vitoriaPlayer.setText(String.valueOf(totalVitoriasPlayer));
        binding.vitoriaAdversario.setText(String.valueOf(totalVitoriasAdversario));
    }
}