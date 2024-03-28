package br.edu.pucgoias.aplicacao02;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SegundaTelaActivity extends AppCompatActivity {

    TextView textViewNome, textViewDescricao, textViewAppNome;
    ImageView imageView;

    Button buttonVoltar;
    boolean isDarkMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        verificarModoEscuro();
        configurarCores();

        String nome = getIntent().getStringExtra("nome");
        String descricao = getIntent().getStringExtra("descricao");
        int imagem = getIntent().getIntExtra("imagem", 0);

        textViewNome = findViewById(R.id.textViewNome);
        textViewDescricao = findViewById(R.id.textViewDescricao);
        textViewAppNome = findViewById(R.id.textViewAppNome);
        imageView = findViewById(R.id.imageView);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        textViewNome.setText(nome);
        textViewDescricao.setText(descricao);
        imageView.setImageResource(imagem);

        buttonVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(SegundaTelaActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void verificarModoEscuro() {
        int modoAtual = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        isDarkMode = modoAtual == Configuration.UI_MODE_NIGHT_YES;
    }

    private void configurarCores() {
        textViewAppNome = findViewById(R.id.textViewAppNome);
        textViewDescricao = findViewById(R.id.textViewDescricao);

        if (isDarkMode) {
            int whiteColor = ContextCompat.getColor(this, R.color.white);
            textViewAppNome.setTextColor(whiteColor);
            textViewDescricao.setTextColor(whiteColor);
        }
    }


}
