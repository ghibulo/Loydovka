import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Deska extends JPanel implements ActionListener
{

    final public int VELIKOST_POLE = 400;
    final public int VELIKOST_MRIZKY = 4;
    final public int RAMECEK = 10;
    final public int VELIKOST_KOSTKY = (VELIKOST_POLE-(VELIKOST_MRIZKY+1)*RAMECEK)/VELIKOST_MRIZKY;
    final public String NIC = "Nic";

    BufferedImage img = null;
    
    Kostka pokus;
    Kostka[][] kostky;
    
    private void vyberObrazek(String jaky) {
        try {
            if (jaky.equals("Škola")) {
              img = ImageIO.read(new File("skola.jpg"));
            } else img = ImageIO.read(new File("linux.png"));
        } catch (IOException e) {
           System.out.println("chyba... nenasel jsem obrazek");
        }
    }
    
    
    public Deska()
    {
        setPreferredSize(new Dimension(VELIKOST_POLE,VELIKOST_POLE));
        vyberObrazek("skola");
        

        
        kostky = new Kostka[VELIKOST_MRIZKY][VELIKOST_MRIZKY];
        //kostky[0][0] = new Kostka("1",10,50,this);
        //kostky[0][1] = new Kostka("2",10,50,this);
        addMouseListener(new LapacMysky());
        int pom = 1;
        Kostka.desk = this;
        for(int ix=0;ix<VELIKOST_MRIZKY;ix++) 
          for(int iy=0;iy<VELIKOST_MRIZKY;iy++)  {
              String naz = (pom!=VELIKOST_MRIZKY*VELIKOST_MRIZKY)?Integer.toString(pom++):NIC;
              kostky[ix][iy] = new Kostka(naz,prevodSouradnic(ix),prevodSouradnic(iy));
              
          }
        
        
    }
    
    private int prevodSouradnic(int vstup) {
        
        return RAMECEK+vstup*(VELIKOST_KOSTKY+RAMECEK);
        
    }
    
    private int prevodSouradnicZ5(int v) {
        return (v-RAMECEK)/(VELIKOST_KOSTKY+RAMECEK);
    }
    
    private boolean sousediKostky(Point s1k, Point s2k) {
        int i = Math.abs(s1k.x-s2k.x)+Math.abs(s1k.y-s2k.y);
        return i==1;
        
    }
    
    
    private void prohodKostky(Point s1k, Point s2k) {
        if (sousediKostky(s1k,s2k)) {
            Kostka pom = kostky[s1k.x][s1k.y];
            kostky[s1k.x][s1k.y] = kostky[s2k.x][s2k.y];
            kostky[s2k.x][s2k.y] = pom;
            kostky[s1k.x][s1k.y].prohodSeSJinou(pom);
        }
    }
    
    private void ukazteSe(Graphics g) {
          for(int ix=0;ix<VELIKOST_MRIZKY;ix++) 
            for(int iy=0;iy<VELIKOST_MRIZKY;iy++)  {
              kostky[ix][iy].ukazSe(g);
              
          }     
    }
    
    private Point dejSouradniceKostky(int x, int y) {
         for(int ix=0;ix<VELIKOST_MRIZKY;ix++) 
            for(int iy=0;iy<VELIKOST_MRIZKY;iy++)  {
              if (kostky[ix][iy].jsiNaPozici(x,y))
                  return new Point(ix,iy);
              
          }  
        return null;
    }

    public void actionPerformed(ActionEvent event) {
        //System.out.println(event.getActionCommand());
        vyberObrazek(event.getActionCommand());
        repaint();
        
        
        
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //g.drawLine(10, 0, 20, 00);
        //g.drawLine(20, 0, 200, 300);
        //g.drawOval(30, 50, 30, 50);
        //pokus.ukazSe(g);
        ukazteSe(g);

    }
    
    public class LapacMysky extends MouseAdapter {
      public void mouseClicked(MouseEvent e) {
       //System.out.println("Mys stistena! "+e.getX()+", "+e.getY());
       Point souradnice = dejSouradniceKostky(e.getX(),e.getY());
       //System.out.println("Nahlasila se kostka o souradnicich... "+souradnice.x+", "+souradnice.y);
    
       Point sourPrM = new Point(prevodSouradnicZ5(Kostka.pozicePrazdnehoMistaX), 
                                 prevodSouradnicZ5(Kostka.pozicePrazdnehoMistaY));
       if (souradnice!=null) {
         prohodKostky(souradnice, sourPrM);
       }
       repaint();
      }
        
    }
    
    
    
}
