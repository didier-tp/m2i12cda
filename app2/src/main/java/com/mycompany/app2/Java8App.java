/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Administrateur
 */
public class Java8App {
    
    public static void main(String[] args) {
        testStreamLamda();
    }
    
    public static void testStreamLamda(){
        Person[] tabPers = { new Person("toto" , 165) , 
                             new Person("dupond" , 145) ,
                             new Person("jacques" , 180) ,
                             new Person("gustave" , 170) 
        };
        
        List<Person> listPers = Arrays.asList(tabPers);
      
        Stream<Person> streamPers = null;
        streamPers = listPers.stream()
                  .filter( (p)-> p.getSize()>=150 )
                  .map( (p) -> { p.setName(p.getName().toUpperCase()); return p; } );
        List<Person> listPers2 = null;
        listPers2 = streamPers.collect(Collectors.toList()); 
        for(Person p : listPers2){
            System.out.println("p(in listPers2)="+p);
        }
        
        listPers.stream()
                  .filter( (p)-> p.getSize()>=150 )
                  .map( (p) -> { p.setName(p.getName().toUpperCase()+"**"); return p; } )
                  .sorted((p1,p2)-> p1.getSize()-p2.getSize())
                  .forEach( (p) -> System.out.println(p) );
    }
    
}
