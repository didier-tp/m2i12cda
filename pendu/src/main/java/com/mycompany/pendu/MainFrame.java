
package com.mycompany.pendu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
    
    char lettreProposee='?';
    
    JPanel panelHaut = new JPanel();
    PanelDessin panelDessin = new PanelDessin();
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
                
        this.boutonRejouer.addActionListener(new 
               /* classe anonyme imbriquée implementant ... */           
                  ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boutonRejouer_actionPerformed(e);
            }
        });
        
        this.textProposition.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                textProposition_keyReleased(e);
            }
        });
        
        this.setVisible(true);
        //fixer option "arreter/exit prog java lorsque fenetre sera fermee"
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//fin de constructeur
    
    public void boutonRejouer_actionPerformed(ActionEvent e){
        //JOptionPane.showMessageDialog(null,"message temporaire");
        this.labelMessage.setText("nouvelle partie");
        this.panelDessin.effacerPendu();
    }
    
    public void textProposition_keyReleased(KeyEvent e){
         //JOptionPane.showMessageDialog(null,"touche relachée");
         this.lettreProposee = e.getKeyChar();
         this.labelMessage.setText("touche relachée = " + e.getKeyChar());
         if(this.lettreProposee == '?'){
             this.panelDessin.dessinerPartiePendu(1);
         }
    }
       
    public static void main(String[] args) {
        MainFrame thisApp = new MainFrame();
    }
}
