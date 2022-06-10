/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moedaporextenso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

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

    public String getInteiro() {
        String stringConverted = String.valueOf(inteiro);
        String stringFormatted = "";
        List<String> porExtensoResult = new ArrayList<>();  
        
            for(int i = 0; i < splittedFields.size(); i++){
                switch(i){
                    case 0 -> {
                    }
                    case 1 -> porExtensoResult.add("mil");
                    case 2 -> porExtensoResult.add("milhões");
                }
                porExtensoResult.add(porExtenso(Integer.parseInt(splittedFields.get(i))));
            }
            
            Collections.reverse(porExtensoResult);
            
        } else {
            porExtensoResult.add(porExtenso(Integer.parseInt(stringConverted)));
        }
        porExtensoResult.add("reais");
        return String.join(" ", porExtensoResult);
    }

    public void setInteiro(int inteiro) {
        this.inteiro = inteiro;
    }

    public String getFracionario() {
        return porExtenso(this.fracionario) + " centavos";
    }

    public void setFracionario(int fracionario) {
        if(fracionario > 99) throw new Error("Forbidden Value");
        this.fracionario = fracionario;
    }
    
    private String reverser(String str, UnaryOperator<String> fun){
        return fun.apply(str);
    }
    
    private String porExtenso(int arg){
        String[] int2StringArr = int2stringConverter.reverser(String.valueOf(arg).split(""));
        String[] convertedValue = new String[int2StringArr.length];
                
        for(int i = 0; i < int2StringArr.length; i++){
            convertedValue[i] = int2stringConverter.matcher(int2StringArr, i);
        }
        
        String[] deversedValue = new String[convertedValue.length];
        
        for(int i = 0; i < deversedValue.length;i++){
            deversedValue[deversedValue.length-i-1] = convertedValue[i];
        }
                        
        String b4Output = String.join(" e ", deversedValue).replace("null e ", "").replace("e zero", "").replace("e null", "");
        return b4Output;
    }
    
    public String getValorCompleto(){
        return getInteiro() + " " + getFracionario();
    }
}
