package database;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author noorSh & halaS
 */
public class DataBase {

    public static void main(String[] args) {
            JPanel logIn  = new LogIn();
            JFrame f=new JFrame();
            f.add(logIn);
           
            f.pack();
            f.setSize(800,500);
            f.setVisible(true);
    }
    
}
