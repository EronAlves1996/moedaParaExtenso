/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moedaporextenso;

/**
 *
 * @author erona
 */
public class Moeda {
    private int inteiro;
    private int fracionario;
    
    Moeda(int i, int f){
        inteiro = i;
        fracionario = f;
    }

    public int getInteiro() {
        return inteiro;
    }

    public void setInteiro(int inteiro) {
        this.inteiro = inteiro;
    }

    public int getFracionario() {
        return fracionario;
    }

    public void setFracionario(int fracionario) {
        this.fracionario = fracionario;
    }
    
    private String porExtenso(int arg){
        return null;
    }
    
    public String getValorCompleto(){
        
    }
}
