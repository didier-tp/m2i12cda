
package com.mycompany.pendu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
    
    char lettreProposee='?';
    int nbEchecs = 0;
    String motAtrouver = "java" ;//valeur par défaut
    String motPartiellementDevine = null;
    String[] tabMots = { "java" , "objet" , "informatique" , "programme" , "polymorphisme" , "window" };
    public static final int NB_MAX_ESSAIS=6;
    //...
    
    
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
        this.panelBas.setBackground(Color.LIGHT_GRAY);
        this.panelHaut.setBackground(Color.CYAN);
        
        //this.textProposition.setMinimumSize(new Dimension(60,20));
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
        initialiserNouvellePartie();
    }//fin de constructeur
    
    public void boutonRejouer_actionPerformed(ActionEvent e){
        //JOptionPane.showMessageDialog(null,"message temporaire");
    	initialiserNouvellePartie();
    	this.boutonRejouer.setEnabled(false);//grisé par défaut
    	//+setfocus sur textProposition
    }
    
    private void initialiserNouvellePartie() {
    	 this.labelMessage.setText("nouvelle partie");
         this.panelDessin.effacerPendu();
         this.nbEchecs = 0;
         int pos = (int) (Math.random() * this.tabMots.length);
         this.motAtrouver = this.tabMots[pos];
         this.motPartiellementDevine=this.initMotPartiellementDevine();
         this.labelMotADeviner.setText(this.motPartiellementDevine);
    }
    

    public void textProposition_keyReleased(KeyEvent e){
         //JOptionPane.showMessageDialog(null,"touche relachée");
         this.lettreProposee = e.getKeyChar();
         this.textProposition.setText(String.valueOf(this.lettreProposee));
         
         if(this.lettreDejaTrouvee(this.lettreProposee)) {
        	 this.labelMessage.setText("lettre déjà proposée et trouvée");
        	 return;
         }
         
         if(this.nouvelleLettreTouvee(this.lettreProposee)) {
        	 this.labelMessage.setText("nouvelle bonne lettre trouvée=" + this.lettreProposee);
        	 this.adjustMotPartiellementDevine(this.lettreProposee);
        	 this.labelMotADeviner.setText(this.motPartiellementDevine);
        	 if(this.motPartiellementDevine.indexOf('-')<0) {
        		 this.labelMessage.setText("BRAVO !!!! le mot trouvé est bien " + this.motAtrouver);
        		 this.boutonRejouer.setEnabled(true);
        	 }
         }else {
        	 this.nbEchecs++;
             this.panelDessin.dessinerPartiePendu(this.nbEchecs);
             if(this.nbEchecs >= NB_MAX_ESSAIS) {
                 this.labelMessage.setText("PENDU !!!! le mot à deviner était " + this.motAtrouver);
                 this.boutonRejouer.setEnabled(true);
             }
        	 
         }
         
        
    }
    
    private String initMotPartiellementDevine() {
    	int taille = this.motAtrouver.length();
    	StringBuilder sb= new StringBuilder(taille);
    	for(int i=0;i<taille;i++)
    		sb.append('-');
    	return sb.toString();
    }
    
    private boolean lettreDejaTrouvee(char c) {
    	return this.motPartiellementDevine.indexOf(c)>=0 ? true : false;
    }
    
    private boolean nouvelleLettreTouvee(char c) {
    	return this.motAtrouver.indexOf(c)>=0 ? true : false;
    }
    
    private void adjustMotPartiellementDevine(char bonneLettreTrouvee) {
    	int taille = this.motPartiellementDevine.length();
    	StringBuilder sb= new StringBuilder(taille);
    	for(int i=0;i<taille;i++) {
    		if(this.motAtrouver.charAt(i)==bonneLettreTrouvee)
    		   sb.append(bonneLettreTrouvee);
    		else
    			sb.append(this.motPartiellementDevine.charAt(i));
    	}
    	this.motPartiellementDevine = sb.toString();
    }
       
    public static void main(String[] args) {
        MainFrame thisApp = new MainFrame();
    }
}
