package com.example.cadprodutos.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Safra implements Serializable {
    private Long id;
    private String variedade;
    private String hec_plant;
    private String data_plant;
    private int quant_sacas_semente;
    private String valor_saca_semente;
    private int quant_sacas_fertilizante;
    private String valor_saca_fertilizante;

//    public Safra(
//            String variedade,
//            String hec_plant,
//            String data_plant,
//            int quant_sacas_semente,
//            String valor_saca_semente,
//            int quant_sacas_fertilizante,
//            String valor_saca_fertilizante
//    ) {
//        this.variedade = variedade;
//        this.hec_plant = hec_plant;
//        this.data_plant = data_plant;
//        this.quant_sacas_semente = quant_sacas_semente;
//        this.valor_saca_semente = valor_saca_semente;
//        this.quant_sacas_fertilizante = quant_sacas_fertilizante;
//        this.valor_saca_fertilizante = valor_saca_fertilizante;
//    }


    @NonNull
    @Override
    public String toString() {
        return variedade.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariedade() {
        return variedade;
    }

    public void setVariedade(String variedade) {
        this.variedade = variedade;
    }

    public String getHec_plant() {
        return hec_plant;
    }

    public void setHec_plant(String hec_plant) {
        this.hec_plant = hec_plant;
    }

    public String getData_plant() {
        return data_plant;
    }

    public void setData_plant(String data_plant) {
        this.data_plant = data_plant;
    }

    public int getQuant_sacas_semente() {
        return quant_sacas_semente;
    }

    public void setQuant_sacas_semente(int quant_sacas_semente) {
        this.quant_sacas_semente = quant_sacas_semente;
    }

    public String getValor_saca_semente() {
        return valor_saca_semente;
    }

    public void setValor_saca_semente(String valor_saca_semente) {
        this.valor_saca_semente = valor_saca_semente;
    }

    public int getQuant_sacas_fertilizante() {
        return quant_sacas_fertilizante;
    }

    public void setQuant_sacas_fertilizante(int quant_sacas_fertilizante) {
        this.quant_sacas_fertilizante = quant_sacas_fertilizante;
    }

    public String getValor_saca_fertilizante() {
        return valor_saca_fertilizante;
    }

    public void setValor_saca_fertilizante(String valor_saca_fertilizante) {
        this.valor_saca_fertilizante = valor_saca_fertilizante;
    }
}
