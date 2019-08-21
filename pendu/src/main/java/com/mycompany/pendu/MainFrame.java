
package com.mycompany.pendu;

import javax.swing.JFrame;


public class MainFrame extends JFrame{
    
    public MainFrame(){
        this.setTitle("pendu");
        this.setBounds(100, 100, 600, 400);
        this.setVisible(true);
        //fixer option "arreter/exit prog java lorsque fenetre sera fermee"
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
       
    public static void main(String[] args) {
        MainFrame thisApp = new MainFrame();
    }
}
