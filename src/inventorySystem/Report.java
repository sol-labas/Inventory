
package inventorySystem;

import static inventorySystem.ProductManagement.conn;
import static inventorySystem.UserManagement.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author angel
 */
public class Report {
    static Connection conn = null;
    public Report(Connection dbconn) {
        this.conn = dbconn;
    } 
    public Set<Totals> allTotals(){
        try {    
            String sql = "SELECT p.id, p.name, SUM(pf.quantity) AS sum_quantity, SUM(pf.cost) AS sum_cost FROM products p"
                    + " JOIN products_flow pf ON (p.id = pf.product_id)"
                    + " GROUP BY p.id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            TreeSet<Totals> products = new TreeSet<Totals>();
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
    public Set<Totals> weekTotals(){
        try {    
            String sql = "SELECT p.id, p.name, SUM(pf.quantity) AS sum_quantity, SUM(pf.cost) AS sum_cost FROM products p"
                    + " JOIN products_flow pf ON (p.id = pf.product_id)"
                    + " WHERE pf.date > ?"
                    + " GROUP BY p.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            
            stmt.setLong(1, timestamp.getTime() - 3600000*24*7);
            ResultSet rs = stmt.executeQuery();
            TreeSet<Totals> products = new TreeSet<Totals>();
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
    public Set<Totals>monthsTotals(){
        try {    
            String sql = "SELECT p.id, p.name, SUM(pf.quantity) AS sum_quantity, SUM(pf.cost) AS sum_cost FROM products p"
                    + " JOIN products_flow pf ON (p.id = pf.product_id)"
                    + " WHERE pf.date > ?"
                    + " GROUP BY p.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            
            stmt.setLong(1, timestamp.getTime() - 3600000*24*7*30);
            ResultSet rs = stmt.executeQuery();
            TreeSet<Totals> products = new TreeSet<Totals>();
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
}
