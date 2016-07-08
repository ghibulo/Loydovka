import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Loyd extends JFrame implements ActionListener {

    public Loyd() {

        
        Deska d = new Deska();
        JMenuBar menuBar = new JMenuBar();
        JMenu vyberObrazku = new JMenu("Výběr obrázku");
        JMenuItem prvniObrazek = new JMenuItem("Škola");
        prvniObrazek.addActionListener(d);
        JMenuItem druhyObrazek = new JMenuItem("Tučňák");
        druhyObrazek.addActionListener(d);
        
        vyberObrazku.add(prvniObrazek);
        vyberObrazku.add(druhyObrazek);
        menuBar.add(vyberObrazku);
        
        setJMenuBar(menuBar);
        
        
        JButton quitButton = new JButton("Konec");
		quitButton.setToolTipText("Tlačítko ukončení");
        
        quitButton.addActionListener(this);

        setLayout(new FlowLayout());
        add(quitButton);
        add(d);
        setTitle("Loyd...");
        
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent event) {
        System.exit(0);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                Loyd ex = new Loyd();
                ex.setVisible(true);
            }
        });
    }
    

    
    
}

