
package database;

import java.awt.Frame;
import javax.swing.JPanel;

/**
 *
 * @author noorSh & halaS
 */

public class DataBase {

   
    public static void main(String[] args) {

        

            Frame f  = new Frame();
            JPanel logIn  = new LogIn();
            f.add(logIn);
            f.pack();
            f.setVisible(true);

    }
    
}
