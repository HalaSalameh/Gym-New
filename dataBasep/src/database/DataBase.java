package database;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author noorSh & halaS
 */
public class DataBase {
    public static JFrame f;
    public static void main(String[] args) {
            JPanel logIn  = new LogIn();
            f=new JFrame();
            f.add(logIn);   
            f.pack();
            f.setSize(800,500);
            f.setVisible(true);
    }
    
    public static void changePanel(JPanel panel,int hight,int width)
    {
         f.add(panel); 
         f.setSize(width,hight);
            
    }
    
}
