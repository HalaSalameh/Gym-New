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
    public static JFrame f;
    public static void main(String[] args) {
            JPanel logIn  = new LogIn();

            f=new JFrame();
            f.add(logIn);   
            f.pack();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            //f.setSize(width/2, height/2);
            f.setSize(logIn.size());
            System.out.println(logIn.size());
            f.setLocationRelativeTo(null);
            f.setVisible(true);
    }
    
    public static void changePanel(JPanel panel,int hight,int width)
    {
        f.setContentPane(panel);
        System.out.println(panel.size());
        f.setSize(panel.preferredSize());
        f.invalidate();
        f.validate();
    }
    
}
