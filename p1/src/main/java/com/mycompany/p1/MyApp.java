
package com.mycompany.p1;

/**
 *
 * @author Administrateur
 */
public class MyApp {
    
    private static void testProduct(){
        Product p1 = null;
        p1 = new Product();
        p1.setPrice(-12.5); //p1.price = 12.5; 
        p1.setLabel("produit 1");//p1.label="produit 1"; 
        p1.setRef(1L);//p1.ref=1L; //1L signifie 1 de type long (ou Long)
        p1.appliquerPromo(20.0);
        System.out.println("p1.price=" + p1.getPrice() /*p1.price*/);
        //System.out.println("p1="+p1.toString());
        System.out.println("p1="+p1);//p1.toString() appelée implicitement.
        
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
    
    public static void main(String[] args) {
        
        testProduct();
        testStringTableau();
        
        System.out.println("Hello world");
        String chVal = "5";

        int val = Integer.parseInt(chVal);
        val = val * 2;
        System.out.println("val="+val);
        
        double v = Double.parseDouble(chVal); // v vaut 5.0
        v = Math.sqrt(v);
        System.out.println("v="+v);
    }
    
    
}
