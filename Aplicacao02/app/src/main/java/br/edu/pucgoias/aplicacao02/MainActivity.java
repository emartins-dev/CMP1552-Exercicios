package br.edu.pucgoias.aplicacao02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textViewDescricao, textViewAppNome;

    RecyclerView recyclerView;
    ArrayList<Item> items;
    Adapter adapter;
    boolean isDarkMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificarModoEscuro();
        configurarCores();

        recyclerView = findViewById(R.id.recyclerView);
        items = new ArrayList<>();

        // Adiciona itens na lista
        items.add(new Item("Cachorro", "Permite o usuário entender e falar com animais.", R.drawable.cachorro));
        items.add(new Item("Carneiro", "Concede uma força sobre-humana.", R.drawable.carneiro));
        items.add(new Item("Cavalo", "Concede uma velocidade sobrenatural.", R.drawable.cavalo));
        items.add(new Item("Coelho", "Proporciona uma habilidade de cura.", R.drawable.coelho));
        items.add(new Item("Dragão", "Concede a capacidade de lançar fogo.", R.drawable.dragao));
        items.add(new Item("Galo", "Concede o poder de levitar e voar.", R.drawable.galo));
        items.add(new Item("Macaco", "Concede uma agilidade extrema e habilidade acrobática.", R.drawable.macaco));
        items.add(new Item("Porco", "Garante invulnerabilidade a qualquer tipo de dano físico.", R.drawable.porco));
        items.add(new Item("Rato", "Concede uma inteligência superior e a habilidade de resolver problemas rapidamente.", R.drawable.rato));
        items.add(new Item("Serpente", "Concede a habilidade de se transformar em outros seres ou objetos.", R.drawable.serpente));
        items.add(new Item("Tigre", "Concede uma força bruta e ferocidade em combate.", R.drawable.tigre));
        items.add(new Item("Touro", "Garante uma resistência incrível e estabilidade mental.", R.drawable.touro));

        // Cria o adapter
        adapter = new Adapter(this, items);

        // Define o layout do RecyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Define o adapter para o RecyclerView
        recyclerView.setAdapter(adapter);
    }

    private void verificarModoEscuro() {
        int modoAtual = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        isDarkMode = modoAtual == Configuration.UI_MODE_NIGHT_YES;
    }

    private void configurarCores() {
        if (isDarkMode) {
            textViewAppNome = findViewById(R.id.textViewApp_Nome);

            int whiteColor = ContextCompat.getColor(this, R.color.white);
            textViewAppNome.setTextColor(whiteColor);

        }
    }
}
