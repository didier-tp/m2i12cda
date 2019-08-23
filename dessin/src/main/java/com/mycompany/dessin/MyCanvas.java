
package com.mycompany.dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.mycompany.dessin.fig.Cercle;
import com.mycompany.dessin.fig.Figure;
import com.mycompany.dessin.fig.Ligne;
import com.mycompany.dessin.fig.Rectangle;


public class MyCanvas extends JPanel {
    
	private Figure figureCourante=null;
	//reference la nouvelle figure à construire
	private List<Figure> listeFigures =  new ArrayList<>();
		
	private Figure.TypeFigure typefigCourante = Figure.TypeFigure.LIGNE;
		
	private Color couleurCourante = Color.BLACK;
	
	public MyCanvas() {

 	   this.addMouseListener(new 
 		 /* classe imbriquee anonyme qui
 		  * implements/extends*/ MouseAdapter(){			
 			public void mousePressed(MouseEvent e) {
 				myCanvas_mousePressed(e);
 			}
 			public void mouseReleased(MouseEvent e) {
 				myCanvas_mouseReleased(e);
 			}		   
 	   }//fin de classe imbriquee
 	   );
 
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Figure fig : this.listeFigures) {
			fig.dessiner(g);
		}
	}



	void myCanvas_mousePressed(MouseEvent e){
		//System.out.println("x1="+e.getX()+ ",y1=" + e.getY());
		switch(this.typefigCourante){
		case LIGNE:
			Ligne l =new Ligne();
			l.setX1(e.getX());l.setY1(e.getY());
			this.figureCourante=l;	break;
		case RECTANGLE:
			Rectangle r =new Rectangle();
			r.setX1(e.getX());r.setY1(e.getY());
			this.figureCourante=r;	break;
		case CERCLE:
			Cercle c =new Cercle();
			c.setXc(e.getX());c.setYc(e.getY());
			this.figureCourante=c;	break;			
		}			
	}
	
	void myCanvas_mouseReleased(MouseEvent e){
		//System.out.println("x2="+e.getX() + ",y2=" + e.getY());
		switch(this.typefigCourante){
		case LIGNE:
			Ligne l = (Ligne) this.figureCourante;
			l.setX2(e.getX());l.setY2(e.getY()); break;
		case RECTANGLE:
			Rectangle r = (Rectangle) this.figureCourante;
			r.setL(Math.abs(e.getX()-r.getX1()));
			r.setH(Math.abs(e.getY()-r.getY1())); 
			if(e.getX() < r.getX1()) r.setX1(r.getX1()-r.getL());
			if(e.getY() < r.getY1()) r.setY1(r.getY1()-r.getH());
			break;
		case CERCLE:
			Cercle c = (Cercle) this.figureCourante;
			int dx=e.getX()-c.getXc();
			int dy=e.getY()- c.getYc();
			c.setRayon((int)Math.sqrt(dx*dx+dy*dy));
		}
		figureCourante.setCouleur(this.couleurCourante);
		figureCourante.dessiner( this.getGraphics());
		this.listeFigures.add(this.figureCourante);
	}

	public Figure getFigureCourante() {
		return figureCourante;
	}

	public void setFigureCourante(Figure figureCourante) {
		this.figureCourante = figureCourante;
	}

	public List<Figure> getListeFigures() {
		return listeFigures;
	}

	public void setListeFigures(List<Figure> listeFigures) {
		this.listeFigures = listeFigures;
	}

	public Figure.TypeFigure getTypefigCourante() {
		return typefigCourante;
	}

	public void setTypefigCourante(Figure.TypeFigure typefigCourante) {
		this.typefigCourante = typefigCourante;
	}

	public Color getCouleurCourante() {
		return couleurCourante;
	}

	public void setCouleurCourante(Color couleurCourante) {
		this.couleurCourante = couleurCourante;
	}
	
	
    
 }
