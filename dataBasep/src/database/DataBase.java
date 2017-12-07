/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.awt.Frame;
import javax.swing.JPanel;

/**
 *
 * @author noorSh & halaS
 */
public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Frame f  = new Frame();
            JPanel logIn  = new LogIn();
            f.add(logIn);
            f.pack();
            f.setVisible(true);
    }
    
}
