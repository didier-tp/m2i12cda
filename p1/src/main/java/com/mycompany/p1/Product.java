
package com.mycompany.p1;

import java.util.Objects;

/**
 *
 * @author Administrateur
 */
// @Getter @Setter @NoArgsConstructor() @ToString de la techno lombok
public class Product /* extends Object */ {
    
    public static final double PRIX_MINI=0.10;
    
    private Long ref;   // null est une valeur possible et par défaut pour Long
                // null serait une valeur impossible pour un long 
    private String label;
    private Double price;
    
    public Double getPrice(){
        return this.price;
    }
    
    public void setPrice(Double price){
        if( price == null || price>= PRIX_MINI)
             this.price=price;
        else { System.out.println("prix negatif interdit");
                this.price=null;
               //this.price inchangé ou this.price = null ou ...
               //plus tard throw new RuntimeException("prix negatif interdit");
        }
    }

    public Long getRef() {
        return ref;
    }

    public void setRef(Long ref) {
        this.ref = ref;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
    public Product(Long ref, String label, Double price ){
        this.ref=ref;this.label = label; this.price=price;
    }
    
    //constructeur par défaut (avec zero paramètre) à coder pour etre sûr qu'il existe
    public Product(){
        //this.ref=0L; this.label=""; this.price=0.0;
        this(0L,"",0.0);
    }
    
    public void appliquerPromo(double pourcentage){
        if(this.price==null)
            return;
        /*else*/
           this.price = this.price * (1 - pourcentage/100);
        //price = price *  (1 - pourcentage/100);
    }

    
    @Override  //à générer via alt insert avec NetBeans
    public String toString() {
        return "Product{" + "ref=" + ref + ", label=" + label + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.ref);
        hash = 47 * hash + Objects.hashCode(this.label);
        hash = 47 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override //à générer via alt insert avec NetBeans
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        if (!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
   
    
    
    
}
