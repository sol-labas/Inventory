
package inventorySystem;

import static inventorySystem.ProductManagement.conn;
import static inventorySystem.UserManagement.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author angel
 */
public class Report {
    /**
     * Database credentials
     */
    static Connection conn = null;
    public Report(Connection dbconn) {
        this.conn = dbconn;
    } 
     /**
     * Function received information about all products and action from database
     * @param 
     * @return ArrayList<Totals>
     */
    public ArrayList<Totals> allTotals(){
        try {    
            String sql = "SELECT p.id, p.name, SUM(pf.quantity) AS sum_quantity, SUM(pf.cost) AS sum_cost FROM products p"
                    + " JOIN product_flow pf ON (p.id = pf.product_id)"
                    + " GROUP BY p.id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Totals> products = new ArrayList<Totals>();
            while (rs.next()) {
                Integer productId = rs.getInt("id");
                String productName = rs.getString("name");
                Integer quantity = rs.getInt("sum_quantity");
                Double cost = rs.getDouble("sum_cost");
                products.add(new Totals(new Product(productId, productName), quantity, cost));
            }
            stmt.close();
            return products;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * Function received information about all products and action from database on weekly basis
     * @param 
     * @return ArrayList<ProductFlowReport>
     */
    public ArrayList<ProductFlowReport> weekReport(){
        try {    
            String sql = "SELECT pf.id, p.name AS product_name, pf.quantity, pf.cost, pf.date, u.name AS user_name FROM product_flow pf"
                    + " JOIN products p ON (p.id = pf.product_id)"
                    + " JOIN users u ON (u.id = pf.user_id)"
                    + " WHERE pf.date > ?"
                    + " ORDER BY pf.date";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime() - 3600000L*24*7);
            stmt.setTimestamp(1, timestamp);
            ResultSet rs = stmt.executeQuery();
            ArrayList<ProductFlowReport> products = new ArrayList<ProductFlowReport>();
            while (rs.next()) {
                String productName = rs.getString("product_name");
                Integer quantity = rs.getInt("quantity");
                Double cost = rs.getDouble("cost");
                Timestamp timstamp = rs.getTimestamp("date");
                String userName = rs.getString("user_name");
                products.add(new ProductFlowReport(new Date(timstamp.getTime()), productName, quantity, cost, userName));
            }
            stmt.close();
            return products;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * Function received information about all products and action from database on monthly basis
     * @param 
     * @return ArrayList<ProductFlowReport>
     */
    public ArrayList<ProductFlowReport>monthReport(){
        try {    
            String sql = "SELECT pf.id, p.name AS product_name, pf.quantity, pf.cost, pf.date, u.name AS user_name FROM product_flow pf"
                    + " JOIN products p ON (p.id = pf.product_id)"
                    + " JOIN users u ON (u.id = pf.user_id)"
                    + " WHERE pf.date > ?"
                    + " ORDER BY pf.date";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime() - 3600000L*24*30);
            stmt.setTimestamp(1, timestamp);
            ResultSet rs = stmt.executeQuery();
            ArrayList<ProductFlowReport> products = new ArrayList<ProductFlowReport>();
            while (rs.next()) {
                String productName = rs.getString("product_name");
                Integer quantity = rs.getInt("quantity");
                Double cost = rs.getDouble("cost");
                Timestamp timstamp = rs.getTimestamp("date");
                String userName = rs.getString("user_name");
                products.add(new ProductFlowReport(new Date(timstamp.getTime()), productName, quantity, cost, userName));
            }
            stmt.close();
            return products;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
