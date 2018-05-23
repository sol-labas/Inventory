
package inventorySystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author angel
 */
public class UserManagement {
    static Connection conn = null;
    public UserManagement(Connection dbconn) {
        this.conn = dbconn;
    } 
    public boolean checkLogin(String name, String passwordRaw) {
        try {    
            String password = passwordToHash(passwordRaw);
            String sql = "SELECT * FROM users WHERE `name` = ? AND `password` = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public User login(String name, String passwordRaw) {
        try {    
            String password = passwordToHash(passwordRaw);
            String sql = "SELECT * FROM users WHERE `name` = ? AND `password` = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String userName = rs.getString("name");
                int userId = rs.getInt("id");
                int isadmin = rs.getInt("isadmin");
                if (isadmin == 0) {
                    return new Staff(userId, userName);
                }
                return new Admin(userId, userName);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public void addUser(String name, String passwordRaw, Boolean isadmin){
        try{
            Integer admin = (isadmin) ? 1 : 0;
            String password = passwordToHash(passwordRaw);
            String sql = "INSERT INTO users (`name`, `password`, `isadmin`) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setInt(3, admin);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public String passwordToHash(String password) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            hash = DatatypeConverter.printHexBinary(md.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return hash;
    }
}
