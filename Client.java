/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banc;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Client {
    //atributs
    private String nom;
    private String cognom;
   
    ArrayList<Conta> comptArray = new ArrayList<Conta>();

    public Client(String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
        
    }

    public String getNom(  ) {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    

    public ArrayList<Conta> getCompta() {
        return comptArray;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

   

    public void setCompta(ArrayList<Conta> compta) {
        this.comptArray = compta;
    }
    
    
}
