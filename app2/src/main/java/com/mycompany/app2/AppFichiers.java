/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
            do {
                ligne = flux3.readLine();
                System.out.println("ligne lue=" + ligne);
            }while(ligne != null);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void modifierListePersonnes(){ 
        
    }
    private void ecrireFichier(String pathName){
        
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
