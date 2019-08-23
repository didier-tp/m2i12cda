package com.mycompany.dessin.fig;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class  Figure implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Color couleur;
	
	public enum TypeFigure { LIGNE , RECTANGLE, CERCLE , AUTRE };
	
	public Figure(){
		couleur=Color.BLACK;//couleur par defaut
	}
	
	abstract public void dessiner(Graphics g);

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	public abstract String toSvgString();
	
	public String getColorAsString(){
		if(couleur.equals(Color.RED)) return "red";
		if(couleur.equals(Color.GREEN)) return "green";
		if(couleur.equals(Color.BLUE)) return "blue";
		if(couleur.equals(Color.YELLOW)) return "yellow";
		else return "black";
	}
	

}
