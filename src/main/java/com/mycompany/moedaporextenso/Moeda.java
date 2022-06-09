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
        int stringFormattedLength = stringConverted.length();
        int fields = 0;
        List<String> splittedFields = new ArrayList<>();
        List<String> porExtensoResult = new ArrayList<>();
                
        if(stringConverted.length() > 3){
            fields = stringFormattedLength/3;
            stringFormatted = reverseString(stringConverted);
            
            for(int i = 0; i <= fields; i++){
                int initIndex = 3 * i;
                int stringFormattedLengthVal = stringFormattedLength;
                int finalIndexVal = 3 * ( i + 1 );
                int finalIndex = stringFormattedLengthVal <= finalIndexVal ? stringFormattedLengthVal : finalIndexVal;
                splittedFields.add(reverser(stringFormatted.substring(initIndex, finalIndex), Moeda::reverseString));
                if(stringFormattedLengthVal == finalIndexVal) break;
            }

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
        String[] int2StringArr = String.valueOf(arg).split("");
        String[] reversedArr = new String[int2StringArr.length];
        String[] convertedValue = new String[int2StringArr.length];
        
        for(int i = 0; i < reversedArr.length;i++){
            reversedArr[reversedArr.length-i-1] = int2StringArr[i] ;
        }
                
        for(int i = 0; i < reversedArr.length; i++){
            switch(i){
                case 0:
                    if (reversedArr.length > 1 && Integer.parseInt(reversedArr[1]) == 1){
                        if(Integer.parseInt(reversedArr[0])==0) {
                            break;
                        }
                        convertedValue[i] = entre10e20extenso[Integer.parseInt(reversedArr[i])-1];
                        i++;
                        break;
                    }
                    convertedValue[i] = valoresExtensos[Integer.parseInt(reversedArr[i])];
                    break;
                case 1:
                    if (Integer.parseInt(reversedArr[i])-1 < 0) break;
                    convertedValue[i] = dezenasExtensas[Integer.parseInt(reversedArr[i])-1];
                    break;
                case 2:
                    if (Integer.parseInt(reversedArr[0]) != 0 
                            && Integer.parseInt(reversedArr[1]) != 0 
                            && Integer.parseInt(reversedArr[i]) == 1) {
                        convertedValue[i] = outros[0];
                        break;
                    }
                    convertedValue[i] = centenasExtensas[Integer.parseInt(reversedArr[i])-1];
                    break;
            }
        }
        
        String[] deversedValue = new String[convertedValue.length];
        
        for(int i = 0; i < deversedValue.length;i++){
            deversedValue[deversedValue.length-i-1] = convertedValue[i];
        }
                        
        String b4Output = String.join(" e ", deversedValue).replace("null e ", "").replace("e zero", "").replace("e null", "");
        return b4Output;
    }
    
    private static String reverseString(String s){
        int stringLength = s.length();
        String newStr = "";
        for(int i = 0; i < stringLength; i++){
            char ch = s.charAt(stringLength-1-i);
            newStr += ch;
        }
        return newStr;
    }
    
    public String getValorCompleto(){
        return getInteiro() + " " + getFracionario();
    }
}
