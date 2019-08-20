
package com.mycompany.p2;


public abstract class Porte {
    private String couleur="blank"; //+get/set
    
    public abstract void ouvrir() ; //code précis seulement dans classes héritées
    public abstract void fermer() ; // pas de code du tout meme pas {}

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    
}
