
package inventorySystem;

/**
 *
 * @author angel
 */
public class Staff implements User {
    private String name;
    private int id;
    /**
     * Constructor
     * @param int userId 
     * @param String userName
     */
    Staff(int userId, String userName) {
        id = userId;
        name = userName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean canAddData() {
        return false;
    }

    @Override
    public boolean canReport() {
        return true;
    }
    
}
