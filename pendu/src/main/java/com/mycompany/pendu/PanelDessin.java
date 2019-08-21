
package com.mycompany.pendu;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PanelDessin extends JPanel {
    
    public void effacerPendu(){
        this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    public void dessinerPartiePendu(int etape){
        Graphics g = this.getGraphics();
        g.setColor(new Color(00,00,255));
        switch(etape){
            case 1:
                g.drawLine(20, 80, 40, 80);
                break;
            case 2:
               g.drawLine(30, 80, 30, 20);
                break;
            //....
        }
    }
}
