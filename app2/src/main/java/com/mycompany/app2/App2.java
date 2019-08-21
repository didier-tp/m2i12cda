
package com.mycompany.app2;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * @author Administrateur
 */
public class App2 {
    
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
