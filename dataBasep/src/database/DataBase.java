package database;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
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
             Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            f.setSize(width/2, height/2);

            f.setLocationRelativeTo(null);
            f.setVisible(true);
    }
    
}
