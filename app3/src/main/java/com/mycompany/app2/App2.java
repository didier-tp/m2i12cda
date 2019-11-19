
package com.mycompany.app2;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.util.BasicAbstractIHM;
import com.mycompany.util.BasicDialogIHM;

/**
 * @author Administrateur
 */
public class App2 {
	
	private static Logger logger = LoggerFactory.getLogger(App2.class);
    
    public static void main(String[] args) {
    	fav2();
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
    	//BasicAbstractIHM myBasicIhm = new BasicTextIHM();
    	BasicAbstractIHM myBasicIhm = new BasicDialogIHM();
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
