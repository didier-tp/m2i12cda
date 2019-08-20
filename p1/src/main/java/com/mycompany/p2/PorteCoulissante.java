
package com.mycompany.p2;


public class PorteCoulissante extends Porte {
    private double ecart;//ouverture (o=ferme , 60ou plus = ouvert
    
    private void faireCoulisser(double ouverture){
        this.ecart = ouverture;
    }
    
    @Override
    public void ouvrir(){
        this.faireCoulisser(60);
        System.out.println("PorteCoulissante ouverte="+this.toString());
    }
    
    @Override
    public void fermer(){
        this.faireCoulisser(0);
        System.out.println("PorteCoulissante fermee="+this.toString());
    }

    @Override
    public String toString() {
        return "PorteCoulissante{" + "ecart=" + ecart + '}';
    }
    
    
    
    
}
