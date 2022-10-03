/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Banc {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Client> llistaClients = new ArrayList<Client>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declaracio de variables
        int opcio = 0;

        do {
            System.out.println("Escull una opcio.\n\n"
                    + "0.- Sortir de l'aplicació.\n"
                    + "1.- Crear client.\n"
                    + "2.- Eliminar client.\n"
                    + "3.- Crear compta d'un client.\n"
                    + "4.- Ingresar euros en una compta d'un client.\n"
                    + "5.- Retirar euros en una compta d'un client.");
            opcio = entrada.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    crearClient();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    crearCompta();
                    break;
                case 4:
                    ingresar();
                    break;
                case 5: retirar();
                    break;
                default:
                    System.out.println("No és una opció valida.");
                    break;
            }
        } while (opcio > 0 && opcio < 5);

    }
//mètode Crear Client

    public static void crearClient() {

        System.out.println("Indica el nom. ");
        String nom = entrada.next();
        System.out.println("Indica el cognom. ");
        String cognom = entrada.next();

        Client nou = new Client(nom, cognom);
        llistaClients.add(nou);
        System.out.println(nou.getNom() + " " + nou.getCognom() + " ara és client d'aquest banc. Ja pot iniciar l'alta d'un compta.");
    }

    //mètode Eliminar Client
    public static void eliminar() {
        String resposta = "", nom = "", cognom = "";
        boolean endloop = false;
        System.out.println("Indica el nom del client que vols elminiar.");
        nom = entrada.next();
        System.out.println("Indica el cognom del client que vols elminiar.");
        cognom = entrada.next();
        //String usuari = nom + cognom;
        for (int i = 0; i < llistaClients.size() && endloop == false; i++) {
            Client borrarClient = llistaClients.get(i);
            if ((borrarClient.getNom().equalsIgnoreCase(nom))
                    && (borrarClient.getCognom().equalsIgnoreCase(cognom))) {
                llistaClients.remove(i);
                endloop = true;
                resposta = nom + " " + cognom + " ha sigut eliminat com a client d'aquest banc.";
            } else {
                resposta = "No existeix ningun client que es digui " + nom + " " + cognom + ".";
            }
        }
        System.out.println(resposta);
    }

    //mètode crear compte d'un client
    public static void crearCompta() {
        String resposta = "", nom = "", cognom = "";
        boolean endloop = false;

        System.out.println("Indica el nom del client.");
        nom = entrada.next();
        System.out.println("Indica el cognom del client.");
        cognom = entrada.next();
        System.out.println("Indica el teu numero de compta amb 4 digits");
        int pass = entrada.nextInt();
        //String usuari = nom + cognom;
        if (llistaClients.size() == 0) {
            resposta = "No hi han clients registrats";
        }
        for (int i = 0; i < llistaClients.size() && endloop == false; i++) {
            Client client = llistaClients.get(i);
            if ((client.getNom().equalsIgnoreCase(nom))
                    && (client.getCognom().equalsIgnoreCase(cognom))) {
                Conta novacompta = new Conta(pass);
                client.comptArray.add(novacompta);
                resposta = "La compta s'ha creat correctament.";
                endloop = true;
            } else {
                resposta = "No figura ningun client: " + nom + " " + cognom + ".";
            }
        }
        System.out.println(resposta);
    }

    //mètode d'ingres
    public static void ingresar() {
        String nom = "", cognom = "", resposta = "";
        boolean endloop = false, endloop2=false;
        System.out.println("Indica el teu nom per poder fer un ingres.");
        nom = entrada.next();
        System.out.println("Indica el teu cognom per poder fer un ingres.");
        cognom = entrada.next();

        for (int i = 0; i < llistaClients.size() && endloop == false; i++) {
            Client ingresClient = llistaClients.get(i);
            if ((ingresClient.getNom().equalsIgnoreCase(nom)) && (ingresClient.getCognom().equalsIgnoreCase(cognom))) {
                System.out.println("Quina compte de les que tens vols fer servir? ");

                for (int j = 0; j < ingresClient.comptArray.size(); j++) {
                    Conta comptesClient = ingresClient.comptArray.get(j);
                    System.out.println(comptesClient.getNumCompta());
                }
                int pass = entrada.nextInt();
                for (int g = 0; g < ingresClient.comptArray.size()&& endloop2 == false; g++) {
                    Conta eleccio = ingresClient.comptArray.get(g);
                    if (eleccio.getNumCompta() == pass&& endloop2 == false) {
                        endloop2 =true;
                        System.out.println("Quina quantitat vols ingresar?");
                        int quantitat = entrada.nextInt();
                        Conta containg = llistaClients.get(i).comptArray.get(g);
                        containg.ingresar(quantitat);
                        resposta = "L'ingres de " + quantitat + "€ s'ha introduít correctament a la compte:"+pass+ ", el saldo actual es de " + containg.getSaldo() + "€.";

                    } else {
                        resposta = "la compta no existeix";
                    }
                }
            }else{
                resposta = "Client incorrecte";
            }
            endloop = true;
        }
        System.out.println(resposta);
    }
    //mètode retirar diners
    public static void retirar() {
        String nom = "", cognom = "", resposta = "";
        boolean endloop = false, endloop2=false;
        System.out.println("Indica el teu nom.");
        nom = entrada.next();
        System.out.println("Indica el teu cognom.");
        cognom = entrada.next();

        for (int i = 0; i < llistaClients.size() && endloop == false; i++) {
            Client retirarClient = llistaClients.get(i);
            if ((retirarClient.getNom().equalsIgnoreCase(nom)) && (retirarClient.getCognom().equalsIgnoreCase(cognom))) {
                System.out.println("Quina conta de les que tens vols fer servir? ");

                for (int j = 0; j < retirarClient.comptArray.size(); j++) {
                    Conta comptesClient = retirarClient.comptArray.get(j);
                    System.out.println(comptesClient.getNumCompta());
                }
                int pass = entrada.nextInt();
                for (int g = 0; g < retirarClient.comptArray.size()&& endloop2 == false; g++) {
                    Conta eleccio = retirarClient.comptArray.get(g);
                    if (eleccio.getNumCompta() == pass && endloop2 == false) {
                        endloop2 = true;
                        System.out.println("Quina quantitat vols retirar?");
                        int quantitat = entrada.nextInt();
                        Conta containg = llistaClients.get(i).comptArray.get(g);
                        containg.retirar(quantitat);
                        resposta = "Has retirat " + quantitat + "€ de la compte: "+pass+". El saldo actual es de " + containg.getSaldo() + "€.";

                    } else {
                        resposta = "la compta no existeix";
                    }
                }
            }else{
                resposta= "Client incorrecte";
            }
            endloop = true;
        }
        System.out.println(resposta);
    }
}

