
package com.mycompany.app2;

import javax.swing.JOptionPane;

/**
 * @author Administrateur
 */
public class App2 {
    
    public static void main(String[] args) {
        
        int a,b;
        a = Integer.parseInt(JOptionPane.showInputDialog("a"));
        b = Integer.parseInt(JOptionPane.showInputDialog("b"));
        int c=a/b;
        JOptionPane.showMessageDialog(null, "a/b="+c);
    }
}
