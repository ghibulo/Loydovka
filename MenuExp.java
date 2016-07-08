 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JOptionPane;

public class MenuExp extends JFrame implements ActionListener {
    
    JCheckBoxMenuItem checkAction;
    JRadioButtonMenuItem radioAction1,radioAction2;
    
    public MenuExp() {
        
        setTitle("Menu Example");
        setSize(150, 150);

        JMenuBar menuBar = new JMenuBar();
        

        setJMenuBar(menuBar);
        

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        

        JMenuItem newAction = new JMenuItem("New");
        newAction.addActionListener(this);
        JMenuItem openAction = new JMenuItem("Open");
        openAction.addActionListener(this);
        JMenuItem exitAction = new JMenuItem("Exit");
        exitAction.addActionListener(this);
        JMenuItem cutAction = new JMenuItem("Cut");
        cutAction.addActionListener(this);
        JMenuItem copyAction = new JMenuItem("Copy");
        copyAction.addActionListener(this);
        JMenuItem pasteAction = new JMenuItem("Paste");
        pasteAction.addActionListener(this);
  
        checkAction = new JCheckBoxMenuItem("Zaškrtávátko");

        radioAction1 = new JRadioButtonMenuItem("Radio Button1");
        radioAction2 = new JRadioButtonMenuItem("Radio Button2");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioAction1);
        bg.add(radioAction2);
        fileMenu.add(newAction);
        fileMenu.add(openAction);
        fileMenu.add(checkAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        editMenu.addSeparator();
        editMenu.add(radioAction1);
        editMenu.add(radioAction2);
    }

    public void actionPerformed(ActionEvent arg) {
        JOptionPane.showMessageDialog(this,"Vybráno... "+arg.getActionCommand());
        JOptionPane.showMessageDialog(this,"Zaškrtnuto..."+checkAction.getState()
                                                          +radioAction1.isSelected()
                                                          +radioAction2.isSelected());
    }
    
    
    public static void main(String[] args) {
        MenuExp me = new MenuExp();
        me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        me.setVisible(true);
    }
}