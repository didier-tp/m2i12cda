
package com.mycompany.p1;

/**
 *
 * @author Administrateur
 */
public class Book extends Product {
    //attributs supplémentaires :
    private String auteur;
    private String editeur;

    @Override
    public String toString() {
        return "Book{" + "auteur=" + auteur + ", editeur=" + editeur + '}'
                + " heritant de " + super.toString();
    }
    
    

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
    
    
}
