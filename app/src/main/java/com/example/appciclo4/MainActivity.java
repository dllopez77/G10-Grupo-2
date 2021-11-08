package com.example.appciclo4;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                }

            }
        });




    }
}