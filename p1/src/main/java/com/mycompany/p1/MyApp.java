
package com.mycompany.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;



/**
 *
 * @author Administrateur
 */
public class MyApp {
    
    private static void testProduct(){
        System.out.println("PRIX_MINI="+ Product.PRIX_MINI);
        
        Product p1 = null;
        try {
            p1 = new Product();
            p1.setPrice(-12.5); //p1.price = 12.5; 
            p1.setLabel("produit 1");//p1.label="produit 1"; 
            p1.setRef(1L);//p1.ref=1L; //1L signifie 1 de type long (ou Long)
            p1.appliquerPromo(20.0);
            System.out.println("p1.price=" + p1.getPrice() /*p1.price*/);
            //System.out.println("p1="+p1.toString());
            System.out.println("p1=" + p1);//p1.toString() appelée implicitement.
        } catch (Exception e) {
            //System.out.println("exception remontée:" + e.getMessage());
            //System.err.println("exception remontée:" + e.getMessage());
            e.printStackTrace();
        }
        
        Product p1Bis = new Product();
        p1Bis.setRef(p1.getRef());
        p1Bis.setPrice(p1.getPrice()); 
        p1Bis.setLabel(p1.getLabel()); 
        
        if(p1Bis.equals(p1))
            System.out.println("p1Bis et p1 ont les memes valeurs");
        else 
            System.out.println("p1Bis et p1 ont des valeurs differentes");
        
        Product p2 = new Product(2L,"produit2",24.5);
        //p2.price = 24.5;
        p2.appliquerPromo(10.0);
        System.out.println("p2.price=" + p2.getPrice());
        System.out.println("p2="+p2.toString());
        
        if(p2 instanceof Product){
            System.out.println("p2 est de type Product");
        }
        
        Buyable choseAchetable=null;
        //choseAchetable = new Byable(); //new impossible sur interface
        choseAchetable = p2;
        System.out.println("prix chose achetable = " 
                           + choseAchetable.getPrice());
    }
    
    private static void testStringTableau(){
        String s1= "m2i paris 12";
        String s2,s3;
        //construire s2 à partir de s1 avec les caractères en MAJUSCULE + affichage
        s2 = s1.toUpperCase(); System.out.println("s2="+s2);
        //construire s3 à partir de s1 en inversant tous les caracères (premier , dernier) + affichage
        StringBuilder sb = new StringBuilder(s1.length());
        for(int i=s1.length()-1;i>=0;i--){
            sb.append(s1.charAt(i));
        }
        s3=sb.toString();System.out.println("s3="+s3);
        
        int[] tabValeurs = new int[4];
        tabValeurs[0] = 12;   tabValeurs[1] = 145;    tabValeurs[2] = 34;     tabValeurs[3] = 68;
        //parcourir le tableau tabValeurs 
        //et pour chaque element , afficher "valeur supérieur ou égal à 50"
        //                              ou "valeur inferieur à 50"
        for(int i=0;i<tabValeurs.length;i++){
            System.out.println( (tabValeurs[i] >= 50) ? "valeur >= 50" : "valeur < 50" );
        }
    }
    
    public static void testMath(){
        double x=4;
        double y=5;
        double h = Math.sqrt( Math.pow(x, 2)+Math.pow(y, 2) ) ;
        System.out.println("h="+h);
        double r=10;
        double s=Math.PI * Math.pow(r,2);
        System.out.println("s="+s);
    }
    
    public static void testBook(){
        Book b1 = new Book();
        b1.setPrice(12.5);
        b1.setLabel("Les Miserables");
        b1.setAuteur("Victor Hugo");
        b1.setEditeur("Editeur Xy");
        System.out.println("b1="+b1.toString());
        
        Book b2 = new Book(2L,"livre 2",15.6,"auteur Aa" , "editeur Bb");
        System.out.println("b2="+b2.toString());
        
        Product refProd = null;
        //refProd= new Product(3L,"prod 3" , 3.3);
        refProd = b2; //Book heritant de Product est vu par java
                       //comme un cas particulier de Product
        refProd.appliquerPromo(10);
        
        
        //refProd.setAuteur("auteur qui va bien"); interdit car setAuteur() 
        //n'est appelable sur n'importe quel Product
        if(refProd instanceof Book){
             Book refBook = (Book) refProd;
             refBook.setAuteur("auteur qui va bien");
        }
        
        System.out.println("refProd="+refProd.toString());
  
     }
    
    private static void testCaddy(){
        Caddy caddy = new Caddy();
        
        Product p1 = new Product(1L,"produit 1",12.0);
        Book b1 = new Book(2L,"livre Xy",8.0,"auteur aa","editeur bb");
        Delivery d1 = new Delivery();
        
        caddy.addItem(p1);
        caddy.addItem(b1);
        caddy.addItem(d1);
        
        System.out.println("prixTotal=" + caddy.totalPrice());
        System.out.println("caddy="+caddy.toString());
    }
    
    private static void testCollection(){
        List<Integer> listDeInteger = new ArrayList<>();
        listDeInteger.add(new Integer(12)); 
        listDeInteger.add(8); 
        listDeInteger.add(24);
        //parcours n° 1 pour multiplier toutes les valeurs par 2
        for(int i=0;i<listDeInteger.size();i++){
            Integer deuxFoisI = new Integer(2*listDeInteger.get(i));
            listDeInteger.set(i, deuxFoisI);
        }
        //parcours n° 2 pour afficher les valeurs.
        for(Integer valI : listDeInteger){
            System.out.println("valI=" + valI);
        }
    }
    
    //MyApp.main() sans new au niveau JVM
    public static void main(String[] args) {
        //testCollection();
        //testCaddy();
        //testMath();
        testProduct();
        //testBook();
        //testStringTableau();
        
        System.out.println("Hello world");
        String chVal = "5"; //valeur par défaut
        /*
        Scanner reader = new Scanner(System.in);
        System.out.print("val:");
        chVal = reader.next();
        */
        
        //chVal = JOptionPane.showInputDialog("valeur de val ?");
        //nécessite import javax.swing.JOptionPane;

        int val = Integer.parseInt(chVal);
        val = val * 2;
        System.out.println("val="+val);
        
        double v = Double.parseDouble(chVal); // v vaut 5.0
        v = Math.sqrt(v);
        System.out.println("v="+v);
    }
    
    
}
