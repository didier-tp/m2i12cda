/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class AppFichiers {
    private List<Person> listePers = new ArrayList<>();
    
    private void chargerFichier(String pathName){
        try {
            FileInputStream flux1 = new FileInputStream(pathName);
            InputStreamReader flux2 = new InputStreamReader(flux1);
            BufferedReader flux3 = new BufferedReader(flux2);
            //flux3 basé sur flux2 basé sur flux1 (design patern "decorateur")
            String ligne=null;
            int numLigne = 0;
            do {
                ligne = flux3.readLine();
                numLigne++;
                System.out.println("ligne lue=" + ligne);
                if(numLigne>1 && ligne !=null){
                    String[] tabParties = ligne.split(";");
                    String nom = tabParties[0];
                    Integer taille = Integer.parseInt(tabParties[1]);
                    Person p = new Person(nom,taille);
                    this.listePers.add(p);
                }
            }while(ligne != null);
           flux3.close(); flux2.close(); flux1.close(); //ameliorable
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void modifierListePersonnes(){ 
        for(Person p : this.listePers){
            //transformer le nom en majuscule:
            p.setName(p.getName().toUpperCase());
            //System.out.println("p="+p.toString());
        }
        listePers.sort(new /* classe anonyme imbriquee implementant ... */
            Comparator<Person>(){
                    @Override
                    public int compare(Person p1, Person p2) {
                        return (p1.getSize() - p2.getSize());
                    }
                });
        for(Person p : this.listePers){
           System.out.println("p="+p.toString());
        }
    }
    private void ecrireFichier(String pathName){
        try {
            FileOutputStream flux1 = new FileOutputStream(pathName);
            PrintStream flux2 = new PrintStream(flux1);
            flux2.println("name;size");
            for(Person p : this.listePers){
                 flux2.println(p.getName()+";"+p.getSize());
               }
            flux2.close(); flux1.close(); //améliorable
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(AppFichiers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        AppFichiers thisApp = new AppFichiers();
        thisApp.chargerFichier("personnes.csv");
        thisApp.modifierListePersonnes();
        thisApp.ecrireFichier("personnes2.csv");
    }
    
    public AppFichiers() {
    }
    
}
