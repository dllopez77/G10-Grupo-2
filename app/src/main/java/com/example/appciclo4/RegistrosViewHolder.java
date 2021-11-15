package com.example.appciclo4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RegistrosViewHolder extends RecyclerView.ViewHolder {
    private TextView txt_peso;
    private TextView txt_talla;
    private TextView txt_imc;
    private TextView txt_fechareg;

    public RegistrosViewHolder(@NonNull View itemview){
        super(itemview);
        txt_peso = (TextView) itemView.findViewById(R.id.info_peso);
        txt_talla = (TextView) itemView.findViewById(R.id.info_talla);
        txt_imc = (TextView) itemView.findViewById(R.id.info_imc);
        txt_fechareg = (TextView) itemView.findViewById(R.id.info_fechareg);
    }

    public TextView getTxt_peso() {
        return txt_peso;
    }

    public TextView getTxt_talla() {
        return txt_talla;
    }

    public TextView getTxt_imc() {
        return txt_imc;
    }

    public TextView getTxt_fechareg() {
        return txt_fechareg;
    }
}
