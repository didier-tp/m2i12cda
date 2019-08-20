
package com.mycompany.p1;


public class Caddy {
    
    //items est un tableau de 50 références
    //sur des choses achetables.
    private Buyable items[] = new Buyable[50];
    int nbItems = 0;
    
    public void addItem(Buyable item){
        if(this.nbItems<50){
            this.items[nbItems]=item;
            nbItems++;
        }
    }
    
    public double totalPrice(){
       double prixTotal = 0.0 ;
       for(int i=0; i<nbItems;i++){
           prixTotal += items[i].getPrice();//polymorphisme
       }
       return prixTotal;
    }

    @Override
    public String toString() {
        String contenu = "Caddy{ nbItems=" + nbItems + ",items=" ;
         for(int i=0; i<nbItems;i++){
             contenu += items[i].toString();
         }
        return contenu + '}';
    
    }
    
}
