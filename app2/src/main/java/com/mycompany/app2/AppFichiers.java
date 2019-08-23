/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class AppFichiers {
    private List<Person> listePers = new ArrayList<>();
    private void chargerFichier(String pathName){ 
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
