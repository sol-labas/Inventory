
package inventorySystem;

/**
 *
 * @author angel
 */
public interface User {
    boolean canAddData();
    boolean canReport();
    
    String getName();
    void setName(String name);
    int getId();
    void setId(int id);
}
