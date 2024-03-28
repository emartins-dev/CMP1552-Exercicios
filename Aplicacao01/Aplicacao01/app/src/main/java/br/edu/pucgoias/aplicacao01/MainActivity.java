package br.edu.pucgoias.aplicacao01;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextValor01, editTextValor02, editTextValor03, editTextValor04;
    TextView textViewValor01, textViewValor02, textViewValor03, textViewValor04, textViewAppNome, textViewOrdemLida, textViewOrdemCrescente, textViewOrdemDecrescente;
    ImageView imageViewCalcular;
    boolean isDarkMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificarModoEscuro();
        configurarCores();

        editTextValor01 = findViewById(R.id.editTextValor01);
        editTextValor02 = findViewById(R.id.editTextValor02);
        editTextValor03 = findViewById(R.id.editTextValor03);
        editTextValor04 = findViewById(R.id.editTextValor04);
        textViewOrdemLida = findViewById(R.id.textViewOrdemLida);
        textViewOrdemCrescente = findViewById(R.id.textViewOrdemCrescente);
        textViewOrdemDecrescente = findViewById(R.id.textViewOrdemDecrescente);
        imageViewCalcular = findViewById(R.id.imageViewCalcular);

        imageViewCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOrdens();
            }
        });
    }

    public void calcularOrdens() {
        String valor01 = editTextValor01.getText().toString();
        String valor02 = editTextValor02.getText().toString();
        String valor03 = editTextValor03.getText().toString();
        String valor04 = editTextValor04.getText().toString();

        if (valor01.isEmpty() || valor02.isEmpty() || valor03.isEmpty() || valor04.isEmpty()) {
            Toast.makeText(MainActivity.this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
        } else {
            List<Integer> valoresDigitados = new ArrayList<>();
            valoresDigitados.add(Integer.parseInt(valor01));
            valoresDigitados.add(Integer.parseInt(valor02));
            valoresDigitados.add(Integer.parseInt(valor03));
            valoresDigitados.add(Integer.parseInt(valor04));

            List<Integer> valoresCrescente = new ArrayList<>(valoresDigitados);
            Collections.sort(valoresCrescente);

            List<Integer> valoresDecrescente = new ArrayList<>(valoresCrescente);
            Collections.reverse(valoresDecrescente);

            StringBuilder ordemLidaBuilder = new StringBuilder("Ordem Lida: ");
            for (Integer valor : valoresDigitados) {
                ordemLidaBuilder.append(valor).append(", ");
            }
            ordemLidaBuilder.setLength(ordemLidaBuilder.length() - 2);
            String ordemLida = ordemLidaBuilder.toString();

            StringBuilder ordemCrescenteBuilder = new StringBuilder("Ordem Crescente: ");
            for (Integer valor : valoresCrescente) {
                ordemCrescenteBuilder.append(valor).append(", ");
            }
            ordemCrescenteBuilder.setLength(ordemCrescenteBuilder.length() - 2);
            String ordemCrescente = ordemCrescenteBuilder.toString();

            StringBuilder ordemDecrescenteBuilder = new StringBuilder("Ordem Decrescente: ");
            for (Integer valor : valoresDecrescente) {
                ordemDecrescenteBuilder.append(valor).append(", ");
            }
            ordemDecrescenteBuilder.setLength(ordemDecrescenteBuilder.length() - 2);
            String ordemDecrescente = ordemDecrescenteBuilder.toString();

            textViewOrdemLida.setText(ordemLida);
            textViewOrdemCrescente.setText(ordemCrescente);
            textViewOrdemDecrescente.setText(ordemDecrescente);
        }
    }

    private void verificarModoEscuro() {
        int modoAtual = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        isDarkMode = modoAtual == Configuration.UI_MODE_NIGHT_YES;
    }

    private void configurarCores() {
        if (isDarkMode) {
            textViewAppNome = findViewById(R.id.textViewApp_Nome);
            textViewOrdemLida = findViewById(R.id.textViewOrdemLida);
            textViewOrdemCrescente = findViewById(R.id.textViewOrdemCrescente);
            textViewOrdemDecrescente = findViewById(R.id.textViewOrdemDecrescente);
            textViewValor01 = findViewById(R.id.textViewValor01);
            textViewValor02 = findViewById(R.id.textViewValor02);
            textViewValor03 = findViewById(R.id.textViewValor03);
            textViewValor04 = findViewById(R.id.textViewValor04);
            imageViewCalcular = findViewById(R.id.imageViewCalcular);

            int whiteColor = ContextCompat.getColor(this, R.color.white);
            textViewAppNome.setTextColor(whiteColor);
            textViewValor01.setTextColor(whiteColor);
            textViewValor02.setTextColor(whiteColor);
            textViewValor03.setTextColor(whiteColor);
            textViewValor04.setTextColor(whiteColor);
            textViewOrdemLida.setTextColor(whiteColor);
            textViewOrdemCrescente.setTextColor(whiteColor);
            textViewOrdemDecrescente.setTextColor(whiteColor);
            imageViewCalcular.setColorFilter(whiteColor);
        }
    }
}