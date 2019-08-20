
package com.mycompany.p2;


public class PortePivotante extends Porte {
    private double angle = 0; //angle ouverture (0 = fermé , 90 = ouvert)

   
    @Override
    public void ouvrir() {
        this.setAngle(90);
        System.out.println("PortePivotante ouverte=" + this.toString());
    }
    
    @Override
    public void fermer() {
        this.setAngle(0);
        System.out.println("PortePivotante fermee=" + this.toString());
    }

    @Override
    public String toString() {
        return "PortePivotante{" + "angle=" + angle + '}';
    }
    
    
    
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

   
}
