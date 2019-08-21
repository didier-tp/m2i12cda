
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
                g.drawLine(20, 240, 40, 240); break;
            case 2:
               g.drawLine(30, 240, 30, 40); break;
            case 3:
                g.drawLine(30, 40, 300, 40); break;
            case 4:
                g.drawOval(250, 40, 100, 50); break;
            case 5:
                g.drawRect(250, 90, 100, 70); break;
            case 6:
                g.drawRect(200, 160, 200, 20); break;
                            
            
        }
    }
}
