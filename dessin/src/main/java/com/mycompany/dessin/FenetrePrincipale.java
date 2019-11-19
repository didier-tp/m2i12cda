
package com.mycompany.dessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.mycompany.dessin.fig.Cercle;
import com.mycompany.dessin.fig.Figure;
import com.mycompany.dessin.fig.Ligne;
import com.mycompany.dessin.fig.Rectangle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FenetrePrincipale extends JFrame{
    
    
    private JPanel panelHaut = new JPanel();
    private MyCanvas panelDessin = new MyCanvas();
    private JRadioButton rbLigne =   new JRadioButton("ligne");
	private JRadioButton rbRectangle = new JRadioButton("rectangle");
	private JRadioButton rbCercle = new JRadioButton("cercle");
	private JComboBox<String> comboCouleur = new JComboBox<String>();
	
    private JButton boutonEffacer = new JButton("effacer");
    private JButton boutonSvg = new JButton("export svg");
    
    public FenetrePrincipale(){
        this.setTitle("dessin");
        this.setBounds(100, 100, 600, 400);
        
        //le niveau intermediaire .getContentPane() est
        //spécifique au JFrame
        this.panelHaut.setBackground(Color.CYAN);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(this.panelHaut,BorderLayout.NORTH);
        this.getContentPane().add(this.panelDessin,BorderLayout.CENTER);
        
        ButtonGroup bg = new ButtonGroup();//exclusivite
        panelHaut.add(rbLigne); bg.add(rbLigne);
        panelHaut.add(rbRectangle); bg.add(rbRectangle);
        panelHaut.add(rbCercle); bg.add(rbCercle);
 	    rbLigne.setSelected(true);
        this.panelHaut.add(this.boutonEffacer);
        this.panelHaut.add(this.boutonSvg);
       
                
        this.boutonEffacer.addActionListener(new 
               /* classe anonyme imbriquée implementant ... */           
                  ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boutonEffacer_actionPerformed(e);
            }
        });
        
        this.boutonSvg.addActionListener(new 
               /* classe anonyme imbriquée implementant ... */           
                  ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boutonSvg_actionPerformed(e);
            }
        });
        
        ActionListener al = new 
        	    /* classe anonyme imbriquee qui implemente */
        	               ActionListener(){
        			public void actionPerformed(ActionEvent e) {
        				boutonRadios_actionPerformed(e);
        			}		  		  
        		   };
        	   rbLigne.addActionListener(al);
        	   rbRectangle.addActionListener(al);
        	   rbCercle.addActionListener(al);
        	   
        	   panelHaut.add(comboCouleur);
        	   comboCouleur.addItem("noir");
        	   comboCouleur.addItem("rouge");
        	   comboCouleur.addItem("vert");
        	   comboCouleur.addItem("bleu");
        	   
        	   comboCouleur.addItemListener(new ItemListener(){
        		public void itemStateChanged(ItemEvent e) {
        			comboCouleur_itemStateChanged(e);			
        		}
        	   });
        	   
        this.setVisible(true);
        //fixer option "arreter/exit prog java lorsque fenetre sera fermee"
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }//fin de constructeur
    
    public void boutonEffacer_actionPerformed(ActionEvent e){
    	panelDessin.getListeFigures().clear();
    	panelDessin.repaint();
    	//this.panelDessin.effacerDessin();
    }
    
     public void boutonSvg_actionPerformed(ActionEvent e){
         try {
             FileOutputStream fos = new FileOutputStream("figures.svg");
             PrintStream ps = new PrintStream(fos);
             StringBuilder sb = new StringBuilder();
             sb.append("<svg xmlns='http://www.w3.org/2000/svg' width='600' height='400'>");
             for (Figure fig : panelDessin.getListeFigures()) {
                 sb.append(fig.toSvgString());
             }
             sb.append("</svg>");
             ps.println(sb.toString());
             ps.close(); fos.close();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
    }
    
	
	
	public void boutonRadios_actionPerformed(ActionEvent e){
	   if(e.getSource()==rbLigne)
		   panelDessin.setTypefigCourante(Figure.TypeFigure.LIGNE);
	   else if(e.getSource()==rbRectangle)
		   panelDessin.setTypefigCourante(Figure.TypeFigure.RECTANGLE);
	   else if(e.getSource()==rbCercle)
		   panelDessin.setTypefigCourante(Figure.TypeFigure.CERCLE);
	}
	
	
	public void comboCouleur_itemStateChanged(ItemEvent e){
		if(e.getStateChange()==ItemEvent.SELECTED){
		  String couleurChoisie = (String)e.getItem();
		  //System.out.println("couleur choisie="+couleurChoisie);
		  if(couleurChoisie.equals("noir")) 
			  panelDessin.setCouleurCourante(Color.BLACK);
		  else if(couleurChoisie.equals("bleu")) 
			  panelDessin.setCouleurCourante(Color.BLUE);
		  else if(couleurChoisie.equals("rouge")) 
			  panelDessin.setCouleurCourante(Color.RED);
		  else if(couleurChoisie.equals("vert")) 
			  panelDessin.setCouleurCourante(Color.GREEN);
			  
		}
	}

    
       
    public static void main(String[] args) {
        FenetrePrincipale thisApp = new FenetrePrincipale();
    }
}
