package com.mycompany.dessin.fig;

import java.awt.Graphics;
import java.text.MessageFormat;


public class Ligne extends Figure{
	
	private int x1,y1,x2,y2; //+get/set
	
	public Ligne() {
		super();
	}


	@Override
	public void dessiner(Graphics g) {
		g.setColor(this.getCouleur());
		g.drawLine(x1, y1, x2, y2);		
	}


	public int getX1() {
		return x1;
	}


	public void setX1(int x1) {
		this.x1 = x1;
	}


	public int getY1() {
		return y1;
	}


	public void setY1(int y1) {
		this.y1 = y1;
	}


	public int getX2() {
		return x2;
	}


	public void setX2(int x2) {
		this.x2 = x2;
	}


	public int getY2() {
		return y2;
	}


	public void setY2(int y2) {
		this.y2 = y2;
	}


	@Override
	public String toSvgString() {		
	 String format=
	  "<line x1=''{0}'' y1=''{1}'' x2=''{2}'' y2=''{3}''  style=''stroke:{4}'' />";		
	 return MessageFormat.format(format,
			 x1,y1,x2,y2,this.getColorAsString());
	}

	
	
}
