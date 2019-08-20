
package com.mycompany.p2;


public class PorteApp {
     public static void testPorte(){
         Porte p = null; //reference sur porte quelconque
         p = new PortePivotante();
         p.setCouleur("black");
         p.ouvrir();
         p.fermer();
        // p = new PorteCoulissante();
         p.ouvrir();
         p.fermer();
     }
    
     public static void main(String[] args) {
         testPorte();
     }
}
