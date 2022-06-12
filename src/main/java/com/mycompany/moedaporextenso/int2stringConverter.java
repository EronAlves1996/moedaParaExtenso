/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moedaporextenso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    
    /** Transforma uma string numérica em um array
     * @param str Uma string numérica
     * @return um array de strings numéricas
     */
    public static String[] transformer(String str){
        return str.split("");
    }
    
    public static String matcher(String[] numberInArr, int index){
        if (Integer.parseInt(numberInArr[index]) - 1 < 0) return "";

        switch(index){
            
            case 0:
                return valoresExtensos[Integer.parseInt(numberInArr[index])];
                
            case 1:
                if (
                        Integer.parseInt(numberInArr[1]) == 1 
                        && !(Integer.parseInt(numberInArr[0]) == 0)
                        ) return entre10e20extenso[Integer.parseInt(numberInArr[0]) - 1];
                
                return dezenasExtensas[Integer.parseInt(numberInArr[index]) - 1];
                
            case 2:
                if ((Integer.parseInt(numberInArr[0]) != 0 
                        || Integer.parseInt(numberInArr[1]) != 0) 
                        && Integer.parseInt(numberInArr[index]) == 1) {
                    return outros[0];
                }
                return centenasExtensas[Integer.parseInt(numberInArr[index]) - 1];
                
        }
        return "";
    }
    
    /** Analisa o array de strings fornecido para indicar
     * a partir de qual index a função matcher irá combinar os números
     * 
     * @param numberInArr Array de strings numéricas (length máxima = 3)
     * @return Um valor de índice
     */
    public static int analyzer(String[] numberInArr){
        if (!(numberInArr.length > 1)) return 0;
        if(numberInArr.length > 3) throw new Error("Invalid Length");

        if (
                (Integer.parseInt(numberInArr[1]) == 1 
                && Integer.parseInt(numberInArr[0]) != 0)
                || Integer.parseInt(numberInArr[0]) == 0
           ) return 1;
        
        if (
                Integer.parseInt(numberInArr[0]) == 0 
                && Integer.parseInt(numberInArr[1]) == 0
           ) return 2;
        
        return 0;
    }
    
    public static String model (UnaryOperator<String> t, String str){
        return t.apply(str);
    }
    
    public static List<String> spliter(String numericString){
        List<String> splittedFields = new ArrayList<>();
        int fields = 0;
        
        if(numericString.length() > 3){
            
            fields = numericString.length()/3;
            numericString = int2stringConverter.model(int2stringConverter::reverser, numericString);
            
            for(int i = 0; i <= fields; i++){
                int initIndex = 3 * i;
                int numericStringLength = numericString.length();
                int finalIndexVal = 3 * ( i + 1 );
                int finalIndex = numericStringLength <= finalIndexVal ? numericStringLength : finalIndexVal;
                
                splittedFields.add(numericString.substring(initIndex, finalIndex));
                if(numericStringLength == finalIndexVal) break;
            }
        }
        System.out.println(splittedFields.toString());
        return splittedFields;    
    }
    
    private static String converter(String str){
        String[] arrString = int2stringConverter.transformer(str);
        List<String> intermediateRepr =  IntStream
                .range(int2stringConverter.analyzer(arrString), arrString.length)
                .mapToObj(i -> int2stringConverter.matcher(arrString, i))
                .filter(i -> !(i.equals("")))
                .collect(Collectors.toList()); 
       Collections.reverse(intermediateRepr);
        return intermediateRepr
                .stream()
                .collect(Collectors.joining(" e "));
    }
    
    private static String attainGreatness(int value, int greatness){
        switch(greatness){
            case 0 -> {
                return "";
            }
            case 1 -> {
                return "mil";
            }
            case 2 -> {
                if(value == 1) return "milhão";
                return "milhões";
            }
            case 3 -> {
                if(value == 1) return "bilhão";
                return "bilhões";
            }
            default -> {
                throw new Error("Grandeza não esperada");
            }
        }
    }
    
    public static String finalGenerator(int number){
        String stringNumber = Integer.toString(number);
        List<String> splittedNumber = int2stringConverter.spliter(stringNumber);
        List<String> intermediateList = IntStream
                .range(0, splittedNumber.size())
                .mapToObj(i -> { 
                    String representation = 
                            int2stringConverter.converter(splittedNumber.get(i)) 
                            + " " + 
                            int2stringConverter.attainGreatness(
                                    Integer.parseInt(splittedNumber.get(i)),
                                    i
                                );
                    if(i == 1) return representation.replace("um mil", "mil");
                    return representation;
                }
                )
                .collect(Collectors.toList());
        Collections.reverse(intermediateList);
        return intermediateList.stream().collect(Collectors.joining(", "));
    }
}