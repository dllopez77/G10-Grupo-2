package com.example.appciclo4;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected ArrayList UnidadMedidaPeso = new ArrayList();
    protected ArrayList UnidadMedidaTalla = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UnidadMedidaPeso.add("Kg");
        UnidadMedidaPeso.add("Lb");

        UnidadMedidaTalla.add("m");
        UnidadMedidaTalla.add("cm");

        ArrayAdapter umPeso= new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,UnidadMedidaPeso);
        ArrayAdapter umTalla= new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,UnidadMedidaTalla);

        Spinner Sp_Peso =(Spinner) findViewById(R.id.sp_Peso);
        Sp_Peso.setAdapter(umPeso);
        Spinner Sp_Talla =(Spinner) findViewById(R.id.sp_Talla);
        Sp_Talla.setAdapter(umTalla);

        EditText Peso =(EditText) findViewById(R.id.TxtPeso);
        EditText Talla =(EditText) findViewById(R.id.TxtTalla);
        Button Btn_calcular =(Button) findViewById(R.id.Btn_Calcula_IMC);
        TextView Result_IMC=(TextView) findViewById(R.id.Lbl_IMC_RES);
        TextView Result_Lbl=(TextView) findViewById(R.id.Lbl_IMC);

        Btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso_local=0;
                double talla_local=0;
                double resultado=0;

                if(Peso.getText().toString().isEmpty()){
                    Peso.setError("Debe Ingresar su Peso.");
                }else{
                    peso_local = Integer.parseInt(Peso.getText().toString()) ;
                }

                if(Talla.getText().toString().isEmpty()){
                    //Toast.makeText(MainActivity.this,"Debe Ingresar su Altura.", Toast.LENGTH_LONG);
                    Talla.setError("Debe Ingresar su Altura.");
                }else{
                    talla_local = Double.parseDouble(Talla.getText().toString());
                }

                if (peso_local>0 && talla_local>0){
                    Result_Lbl.setVisibility(View.VISIBLE);
                    Result_IMC.setVisibility(View.VISIBLE);
                    //talla_local=talla_local/100;
                    resultado= (peso_local/(talla_local*talla_local));

                    DecimalFormat df = new DecimalFormat("#.#");
                    //Result_IMC.append(String.valueOf(df.format(resultado)));
                    Result_IMC.setText(String.valueOf(df.format(resultado)));
                    //Result_IMC.setText(String.valueOf(Sp_Peso.getSelectedItem().toString()));
                }

            }
        });




    }
}