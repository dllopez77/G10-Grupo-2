package com.example.appciclo4;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appciclo4.model.RegistroImc;

import java.util.List;

public class AdapterRegistros extends RecyclerView.Adapter<RegistrosViewHolder> {
    Context context_;
    int layout;
    List<RegistroImc> lista;
    LayoutInflater inflater;

    DecimalFormat df = new DecimalFormat("#.#");
    public AdapterRegistros(Context context, int layout, List<RegistroImc> lista) {
        this.context_ = context;
        this.layout = layout;
        this.lista = lista;
        this.inflater=LayoutInflater.from(context_);
    }
    @NonNull
    @Override
    public RegistrosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype){
        View vista = inflater.inflate(layout, parent, false);
        return new RegistrosViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull RegistrosViewHolder holder, int position) {
        RegistroImc registros = lista.get(position);

        holder.getTxt_peso().setText(registros.getPeso()+"");
        holder.getTxt_talla().setText(registros.getTalla()+"");
        holder.getTxt_imc().setText(df.format(registros.getResultado()) +"");
        holder.getTxt_fechareg().setText(registros.getFechaRegistro());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
