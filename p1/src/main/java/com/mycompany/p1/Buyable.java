
package com.mycompany.p1;


public interface Buyable {
    public Double getPrice();
    public void setPrice(Double price);
    //public String autreMethodeEventuelle(...);
    public static final String DEFAULT_CURRENCY="euro";
}
