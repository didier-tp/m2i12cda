
package com.mycompany.app3;

import java.util.List;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.dao.DeviseDao;
import com.mycompany.dao.DeviseDaoJdbc;
import com.mycompany.dao.DeviseDaoSimulation;
import com.mycompany.entity.Devise;
import com.mycompany.util.BasicDialogIHM;
import com.mycompany.util.BasicIHM;

/**
 * @author Administrateur
 */
public class App3 {
	
	private static Logger logger = LoggerFactory.getLogger(App3.class);
    
    public static void main(String[] args) {
    	//fav1();
    	//fav2();
    	testDevise();
    }
        
    public static void testDevise() {
    	DeviseDao deviseDao = null;
    	deviseDao = new DeviseDaoSimulation();
    	deviseDao = new DeviseDaoJdbc();
    	List<Devise> listeDevises = deviseDao.rechercherToutesDevise();
    	System.out.println("Liste des devises:");
    	for(Devise d : listeDevises) {
    		System.out.println("\t"+d);
    	}
    	//exemple d'enchainement avec  stream et lambda (java >=8):
    	listeDevises.stream().map( (d)-> { d.setNom(d.getNom().toUpperCase()); return d;})
    	                     .forEach( (d) -> { System.out.println("\t >>> "+d);});
    }
    
    public static void fav1() {
        int a,b,c;
        try {
            a = Integer.parseInt(JOptionPane.showInputDialog("a"));
            b = Integer.parseInt(JOptionPane.showInputDialog("b"));
            c = a / b;
            logger.trace("a/b=" + c);
            JOptionPane.showMessageDialog(null, "a/b=" + c);
        }  catch (Exception e) {
        	logger.error("exception:" + e.getMessage());
            JOptionPane.showMessageDialog(null, "exception:" + e.getMessage());
        }
    }
    
    public static void fav2() {
    	//BasicAbstractIHM myBasicIhm = new BasicAbstractIHM();//new impossible sur classe abstraite
    	BasicIHM myBasicIhm = null;//classe abstraite ou interface = type de référence possible
    	//myBasicIhm = new BasicTextIHM();
    	myBasicIhm = new BasicDialogIHM();
        int a,b,c;
        try {
            a = Integer.parseInt(myBasicIhm.saisir("a"));
            b = Integer.parseInt(myBasicIhm.saisir("b"));
            c = a / b;
            logger.trace("a/b=" + c);
            myBasicIhm.afficher( "a/b=" + c);
        }  catch (Exception e) {
        	logger.error("exception:" + e.getMessage());
        	myBasicIhm.afficher( "exception:" + e.getMessage());
        }
    }

}
