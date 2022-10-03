/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banc;

/**
 *
 * @author Administrador
 */
public class Conta {
    //atributs
    private int numCompta;
    private double saldo = 0;
    
    //contructor
    
    public Conta(int numCompta) {
        this.numCompta = numCompta;
        this.saldo = saldo;
    }
    
    //getters
    
    public int getNumCompta() {
        return numCompta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    //mètode per ingresar
    
    public void ingresar(double quantitat){
        this.saldo += quantitat;
    }
    
    //mètode de retirada 
    
    public void retirar(double quantitat){
        this.saldo -= quantitat;
    }
}
