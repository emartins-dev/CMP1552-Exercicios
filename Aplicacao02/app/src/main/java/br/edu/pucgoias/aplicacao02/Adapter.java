package br.edu.pucgoias.aplicacao02;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Item> items;
    LayoutInflater inflater;

    public Adapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewNome.setText(items.get(position).getNome());
        holder.imageView.setImageResource(items.get(position).getImagem());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemSelecionado = items.get(position).getNome();
                String descricaoSelecionada = items.get(position).getDescricao();
                int imagemSelecionada = items.get(position).getImagem();

                Intent intent = new Intent(context, SegundaTelaActivity.class);
                intent.putExtra("nome", itemSelecionado);
                intent.putExtra("descricao", descricaoSelecionada);
                intent.putExtra("imagem", imagemSelecionada);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNome, textViewDescricao;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
