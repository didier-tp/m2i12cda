
package com.mycompany.pendu;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
    
    JPanel panelHaut = new JPanel();
    JPanel panelDessin = new JPanel();
    JPanel panelBas = new JPanel();
    JLabel labelMessage = new JLabel("jusqu'ici tout va bien");
    JLabel labelMotADeviner = new JLabel("--------");
    JTextField textProposition = new JTextField("?");
    JButton boutonRejouer = new JButton("nouvelle partie");
    
    public MainFrame(){
        this.setTitle("pendu");
        this.setBounds(100, 100, 600, 400);
        
        //le niveau intermediaire .getContentPane() est
        //spécifique au JFrame
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(this.panelHaut,BorderLayout.NORTH);
        this.getContentPane().add(this.panelDessin,BorderLayout.CENTER);
        this.getContentPane().add(this.panelBas,BorderLayout.SOUTH);
        
        this.panelHaut.add(this.labelMotADeviner);//en FlowLayout par defaut
        this.panelHaut.add(this.textProposition);
        this.panelHaut.add(this.boutonRejouer);
        this.panelBas.add(this.labelMessage);//en FlowLayout par defaut
        
        this.setVisible(true);
        //fixer option "arreter/exit prog java lorsque fenetre sera fermee"
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
       
    public static void main(String[] args) {
        MainFrame thisApp = new MainFrame();
    }
}
