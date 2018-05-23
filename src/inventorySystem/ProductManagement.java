
package inventorySystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Date;

/**
 *
 * @author angel
 */
public class ProductManagement {
    static Connection conn = null;
    public ProductManagement(Connection dbconn) {
        this.conn = dbconn;
    } 
    public Product addProduct(String name){
        try{
            String sql = "INSERT INTO product (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            Integer id = stmt.executeUpdate("", Statement.RETURN_GENERATED_KEYS);
            stmt.close();
            return getProductById(id);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Product getProductById(Integer id) {
        try {    
            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Integer productId = rs.getInt("id");
                String productName = rs.getString("name");
                return new Product(productId, productName);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public HashMap<Integer, Product> getProductList(){
        try {    
            String sql = "SELECT * FROM products";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            HashMap<Integer, Product> products = new HashMap<Integer, Product>();
            while (rs.next()) {
                Integer productId = rs.getInt("id");
                String productName = rs.getString("name");
                products.put(productId, new Product(productId, productName));
            }
            stmt.close();
            return products;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public void changeProduct(Product product, Integer quantity, Double cost, Date addDate, User user){
        try{
            Timestamp timestamp = new Timestamp(addDate.getTime());
            String sql = "INSERT INTO product_flow (product_id, quantity, cost, date, user_id) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product.getId());
            stmt.setInt(2, quantity);
            stmt.setDouble(3, cost);
            stmt.setLong(4, timestamp.getTime());
            stmt.setInt(5, user.getId());
            Integer id = stmt.executeUpdate("", Statement.RETURN_GENERATED_KEYS);
            stmt.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
