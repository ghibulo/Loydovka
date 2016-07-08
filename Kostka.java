import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Kostka
{

    int sx, sy, ox, oy;
    String napis;
    static Deska desk;
    
    static int pozicePrazdnehoMistaX, pozicePrazdnehoMistaY;
    
    public Kostka(String n, int x, int y)
    {
        ox=sx=x;
        oy=sy=y;
        napis=n;
        
        kontrolaNic();
    }

    private void kontrolaNic () {
        if (napis.equals(desk.NIC)) {
            pozicePrazdnehoMistaX = sx;
            pozicePrazdnehoMistaY = sy;
        }
    }
    
    public void ukazSe(Graphics g) {
        int s = desk.VELIKOST_KOSTKY;
        g.drawRect(sx, sy, s,s);
        if (!(napis.equals(desk.NIC))) {
        
          g.drawImage(desk.img, sx, sy, sx+s,sy+s, ox, oy, ox+s, oy+s,null);
          g.drawString(napis, sx+s/2, sy+s/2);
        }
        
    }

    public void prohodSeSJinou(Kostka k) {
        int px = k.sx;
        int py = k.sy;
        k.sx = sx;k.sy = sy;sx = px; sy = py;
        kontrolaNic();k.kontrolaNic();
    }
    
    public boolean jsiNaPozici(int x, int y) {
        return ((x>sx)&&(x<sx+desk.VELIKOST_KOSTKY)&&(y>sy)&&(y<sy+desk.VELIKOST_KOSTKY));

    }
    
    
    
}
