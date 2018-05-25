
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
    /**
     * Database credentials
     */
    static Connection conn = null;
    public ProductManagement(Connection dbconn) {
        this.conn = dbconn;
    } 
    
    /**
     * Function add new product to database
     * @param String name 
     * @return Product class
     */
    public Product addProduct(String name){
        try{
            String sql = "INSERT INTO products (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            Integer id = 0;
            Integer affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                return null;
            }

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
            stmt.close();
            return getProductById(id);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * Function received information about product from database
     * @param Integer id 
     * @return Product class
     */
    
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
    
    /**
     * Function received information about product from database
     * @param String name 
     * @return Product class
     */
    public Product getProductByName(String name) {
        try {    
            String sql = "SELECT * FROM products WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
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
    /**
     * Function received information about all products from database
     * @param 
     * @return HashMap<Integer, Product>
     */
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
    /**
     * Function change information about product in database
     * @param Product product, Integer quantity, Double cost, Date addDate, User user
     * @return void
     */
    public void changeProduct(Product product, Integer quantity, Double cost, Date addDate, User user){
        try{
            Timestamp timestamp = new Timestamp(addDate.getTime());
            String sql = "INSERT INTO product_flow (product_id, quantity, cost, date, user_id) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product.getId());
            stmt.setInt(2, quantity);
            stmt.setDouble(3, cost);
            stmt.setTimestamp(4, timestamp);
            stmt.setInt(5, user.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
