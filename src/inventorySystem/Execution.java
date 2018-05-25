
package inventorySystem;

import frames.InventorySystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Execution {
    /**
     * Database credentials
     */
    static String dbUrl = "jdbc:mysql://localhost:3306/inventory";
    static String uname = "root";
    static String pw = "";
    /**
     * Connection to database
     */
    public static Connection conn = null;
    /**
     * User that currently logged in to system
     */
    public static User loggedUser = null;
    
    /**
     * Main execution function
     * @param args 
     */
    public static void main(String[] args) {
         try {
            conn = DriverManager.getConnection(dbUrl, uname, pw);

            UserManagement usermgmt = new UserManagement(conn);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new InventorySystem().setVisible(true);
                }
            });
        } catch(SQLException ex){
            ex.printStackTrace();
        } 
    }
    
}
