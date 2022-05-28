/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moedaporextenso;

import java.util.Arrays;

/**
 *
 * @author erona
 */
public class Moeda {
    private int inteiro;
    private int fracionario;
    
    Moeda(int i, int f){
        this.setInteiro(i);
        this.setFracionario(f);
    }

    public int getInteiro() {
        return inteiro;
    }

    public void setInteiro(int inteiro) {
        this.inteiro = inteiro;
    }

    public String getFracionario() {
        return porExtenso(this.fracionario);
    }

    public void setFracionario(int fracionario) {
        this.fracionario = fracionario;
    }
    
    private String porExtenso(int arg){
        String[] int2StringArr = String.valueOf(arg).split("");
        String[] valoresExtensos = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
        Object[] number2extenso = Arrays.stream(int2StringArr).map(n -> valoresExtensos[Integer.parseInt(n)]).toArray();
        return number2extenso[0].toString();
    }
    
    public String getValorCompleto(){
        return null;
    }
}
