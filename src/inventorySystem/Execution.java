
package inventorySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author angel
 */
public class Execution {
    static String dbUrl = "jdbc:mysql://localhost:3306/inventory";
    static String uname = "root";
    static String pw = "";

    public static void main(String[] args) {
        Connection conn = null;
         try {
            conn = DriverManager.getConnection(dbUrl, uname, pw);

            UserManagement usermgmt = new UserManagement(conn);
            //usermgmt.addUser("user", "1234", Boolean.FALSE);
            //usermgmt.addUser("admin", "1234", Boolean.TRUE);
            System.out.println(usermgmt.login("user", "1234"));
            System.out.println(usermgmt.login("admin", "1234"));
            conn.close(); 
        } catch(SQLException ex){
            ex.printStackTrace();
        } 
    }
}
