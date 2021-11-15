package com.example.appciclo4.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroImc {
    private float Peso;
    private float Talla;
    private float Resultado;
    private String FechaRegistro;

    public RegistroImc(float peso, float talla, String fechaRegistro) {
        this.Peso = peso;
        this.Talla = talla;
        this.FechaRegistro = fechaRegistro;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        this.Peso = peso;
    }

    public float getTalla() {
        return Talla;
    }

    public void setTalla(float talla) {
        this.Talla = talla;
    }

    public float getResultado() {
        Resultado=(Peso/(Talla*Talla));
        return Resultado;
    }

    public void setResultado(float resultado) {
        this.Resultado = resultado;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.FechaRegistro = fechaRegistro;
    }
}
