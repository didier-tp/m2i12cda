
package com.mycompany.p1;


public class Book extends Product {
    //attributs supplémentaires :
    private String auteur;
    private String editeur;
    
    public Book(){
        super();
        this.editeur="editeur par defaut";
    }
    
    public Book(Long ref,String label,Double prix,String auteur,String editeur){
        super(ref,label,prix);//passage de param au constructeur hérité de Product
        this.auteur=auteur;
        this.editeur=editeur;
    }

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
