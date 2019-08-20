
package com.mycompany.p1;


public class Delivery implements Buyable{
    
    private String destination="destination xyz"; //adresse livraison
    private Double deliveryPrice=1.0;

    @Override
    public Double getPrice() {
        return this.deliveryPrice;
    }

    @Override
    public void setPrice(Double price) {
       this.deliveryPrice=price;
    }

    @Override
    public String toString() {
        return "Delivery{" + "destination=" + destination + ", deliveryPrice=" + deliveryPrice + '}';
    }
    
    
    
}
