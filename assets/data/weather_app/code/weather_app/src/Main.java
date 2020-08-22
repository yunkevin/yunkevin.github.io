/*
By: Jacob Chamberlain
    Kevin Yun

Created for: C. Balant at MCW Consultants
 */
package cpt;


import java.io.IOException;
import java.text.ParseException;


/**
 *
 * @author User
 */
public class Main {

    private static Time time = new Time();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
        
        MainUI main = new MainUI();
        main.setVisible(true);
        
    }
}