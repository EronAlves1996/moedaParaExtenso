/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moedaporextenso;


/**
 *
 * @author erona
 */
public class int2stringConverter {
    private static final String[] valoresExtensos = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
    private static final String[] entre10e20extenso = {"onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
    private static final String[] dezenasExtensas = {"dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
    private static final String[] centenasExtensas = {"cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
    private static final String[] outros = {"cento"};
    
    public static String reverser(String t){
        int length = t.length();
        String newStr = "";
        for(int i = 0; i < length; i++){
            char ch = t.charAt(length-1-i);
            newStr += ch;
        }
        return newStr;
    }
    
    public static <T> T[] reverser(T[] t){
        int length = t.length;
        T[] newArr = (T[]) new Object[length];
        for(int i = 0; i<length;i++){
            newArr[i] = t[length-1-i];
        }
        return newArr;
    }
    
    public static String matcher(String[] numberInArr, int index){
        
        switch(index){
            
            case 0:
                return valoresExtensos[Integer.parseInt(numberInArr[index])];
                
            case 1:
                if (Integer.parseInt(numberInArr[index]) - 1 < 0) return "";
                
                if (
                        Integer.parseInt(numberInArr[1]) == 1 
                        && !(Integer.parseInt(numberInArr[0]) == 0)
                        ) return entre10e20extenso[Integer.parseInt(numberInArr[index]) - 1];
                
                return dezenasExtensas[Integer.parseInt(numberInArr[index]) - 1];
                
            case 2:
                if (Integer.parseInt(numberInArr[0]) != 0 
                        && Integer.parseInt(numberInArr[1]) != 0 
                        && Integer.parseInt(numberInArr[index]) == 1) {
                    return outros[0];
                }
                return centenasExtensas[Integer.parseInt(numberInArr[index]) - 1];
                
        }
        return "";
    }
    
    public static int analyzer(String[] numberInArr){
        if (!(numberInArr.length > 1)) return 0;
        if(numberInArr.length > 3) throw new Error("Invalid Length");

        if (
                Integer.parseInt(numberInArr[1]) == 1 
                && Integer.parseInt(numberInArr[0]) != 0
           ) return 1;
        
        if (
                Integer.parseInt(numberInArr[0]) == 0 
                && Integer.parseInt(numberInArr[1]) == 0
           ) return 2;
        
    }
    
    
}
