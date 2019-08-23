
package com.mycompany.app2;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

/**
 * @author Administrateur
 */
public class App2 {
    
    
    public static void testStreamLamda(){
        Person[] tabPers = { new Person("toto" , 165) , 
                             new Person("dupond" , 145) ,
                             new Person("jacques" , 180) ,
                             new Person("gustave" , 170) 
        };
        
        List<Person> listPers = Arrays.asList(tabPers);
        Stream<Person> streamPers = null;
        List<Person> listPers2 = null;
        
      
        streamPers = listPers.stream()
                .filter( (p)-> p.getSize()>=150 );
               
        
        listPers2 = streamPers.collect(Collectors.toList()); 
        for(Person p : listPers2){
            System.out.println("p="+p);
        }
    }
    
    public static void main(String[] args) {
        
        int a,b,c;
        try {
            a = Integer.parseInt(JOptionPane.showInputDialog("a"));
            b = Integer.parseInt(JOptionPane.showInputDialog("b"));
            c = a / b;
            JOptionPane.showMessageDialog(null, "a/b=" + c);
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, "exception:" 
                        + e.getMessage());
        }
    }
}
