
package com.mycompany.p1;

import java.util.ArrayList;
import java.util.List;


public class Caddy {
    
    //private List<Buyable> items = new ArrayList<Buyable>();
    private List<Buyable> items = new ArrayList<>();//syntaxe simplifiée depuis jdk 1.7
    
    public void addItem(Buyable item){
        items.add(item); //Collection.add(...) et List herite de Collection
    }
    
    public double totalPrice(){
       double prixTotal = 0.0 ;
       /*
       for(int i=0; i<items.size();i++){
           prixTotal += items.get(i).getPrice();//polymorphisme
       }*/
       
       //for au sens forEach()
       for(Buyable b : items){
           prixTotal += b.getPrice();//polymorphisme
       }
       return prixTotal;
    }

    @Override
    public String toString() {
        String contenu = "Caddy{ nbItems=" + items.size() + ",items=" ;
          for(Buyable b : items){
             contenu += b.toString();
         }
        return contenu + '}';
    
    }
    
}
