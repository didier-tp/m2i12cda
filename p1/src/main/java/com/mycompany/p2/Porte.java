
package com.mycompany.p2;


public abstract class Porte {
    private String couleur="blank"; //+get/set
    
    public abstract void ouvrir() ; //code précis dans classes héritées
    public abstract void fermer() ;

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    
}
