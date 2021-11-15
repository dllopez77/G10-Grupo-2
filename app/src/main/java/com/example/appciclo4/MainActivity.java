package com.example.appciclo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appciclo4.model.RegistroImc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    protected ArrayList UnidadMedidaPeso = new ArrayList();
    protected ArrayList UnidadMedidaTalla = new ArrayList();

    protected ArrayList<RegistroImc>ArrayRegistros = new ArrayList<RegistroImc>();
    DecimalFormat df = new DecimalFormat("#.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayRegistros.add(new RegistroImc(70,Float.parseFloat("1.55"),"01/01/2021"));
        ArrayRegistros.add(new RegistroImc(71,Float.parseFloat("1.56"),"01/02/2021"));
        ArrayRegistros.add(new RegistroImc(72,Float.parseFloat("1.57"),"01/03/2021"));
        ArrayRegistros.add(new RegistroImc(73,Float.parseFloat("1.58"),"01/04/2021"));
        ArrayRegistros.add(new RegistroImc(74,Float.parseFloat("1.59"),"01/05/2021"));
        ArrayRegistros.add(new RegistroImc(75,Float.parseFloat("1.60"),"01/06/2021"));
        ArrayRegistros.add(new RegistroImc(76,Float.parseFloat("1.61"),"01/07/2021"));
        ArrayRegistros.add(new RegistroImc(77,Float.parseFloat("1.62"),"01/08/2021"));
        ArrayRegistros.add(new RegistroImc(78,Float.parseFloat("1.63"),"01/09/2021"));
        ArrayRegistros.add(new RegistroImc(79,Float.parseFloat("1.64"),"01/10/2021"));
        ArrayRegistros.add(new RegistroImc(80,Float.parseFloat("1.65"),"01/11/2021"));

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
        Button Btn_Ver_Registros =(Button) findViewById(R.id.Btn_Ver_Registros);
        RecyclerView lista_registros = (RecyclerView) findViewById(R.id.lista_registros);
        LinearLayout FormInicio =(LinearLayout) findViewById(R.id.Layout_Formulario);
        LinearLayout FormRegistros =(LinearLayout) findViewById(R.id.Layout_Registros);
        Button Nuevo_Registro =(Button) findViewById(R.id.Nuevo_Registro);

        //DatePicker datePicker =(DatePicker) findViewById(R.id.datePicker);

        Btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FormRegistros.setVisibility(View.GONE);
                float peso_local=0;
                float talla_local=0;
                float resultado=0;

                if(Peso.getText().toString().isEmpty()){
                    Peso.setError("Debe Ingresar su Peso.");
                }else{
                    peso_local = Integer.parseInt(Peso.getText().toString()) ;
                }

                if(Talla.getText().toString().isEmpty()){
                    //Toast.makeText(MainActivity.this,"Debe Ingresar su Altura.", Toast.LENGTH_LONG);
                    Talla.setError("Debe Ingresar su Altura.");
                }else{
                    talla_local = Float.parseFloat(Talla.getText().toString());
                }

                if (peso_local>0 && talla_local>0){
                    Result_Lbl.setVisibility(View.VISIBLE);
                    Result_IMC.setVisibility(View.VISIBLE);
                    //talla_local=talla_local/100;
                    resultado= (peso_local/(talla_local*talla_local));


                    //Result_IMC.append(String.valueOf(df.format(resultado)));
                    Result_IMC.setText(String.valueOf(df.format(resultado)));
                    if(ArrayRegistros.add(new RegistroImc(peso_local,talla_local,"01/11/2021"))){
                        Toast.makeText(MainActivity.this,"Registro Agregado", Toast.LENGTH_SHORT).show();
                    }
                    //Result_IMC.setText(String.valueOf(Sp_Peso.getSelectedItem().toString()));
                }

            }
        });

        Context contexto=this;
        Btn_Ver_Registros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AdapterRegistros adaptador = new AdapterRegistros(contexto, R.layout.layout_custom_registros, ArrayRegistros);
                lista_registros.setAdapter(adaptador);
                lista_registros.setLayoutManager(new LinearLayoutManager(contexto));
                lista_registros.setHasFixedSize(true);
                FormRegistros.setVisibility(View.VISIBLE);
                FormInicio.setVisibility(View.GONE);

            }

        });

        Nuevo_Registro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FormInicio.setVisibility(View.VISIBLE);
                FormRegistros.setVisibility(View.GONE);
            }

        });

        /*Talla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }

        });

        public void showDatePickerDialog(){
            DatePickerDialog datePickerDialog =new DatePickerDialog(
                    context:this,
                    listener:this,
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );*/

        }





    }
