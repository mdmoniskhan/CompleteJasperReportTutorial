/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaspertutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monis
 */
public class JASPERTUTORIAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/solar";
            Connection conn = DriverManager.getConnection(url, "root", "123456789");
            
            String chid = "1086";
            new Print(chid, conn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JASPERTUTORIAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JASPERTUTORIAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
