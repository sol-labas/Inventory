
package inventorySystem;

/**
 *
 * @author angel
 */
public class Admin implements User {
    private String name;
    private int id;
    /**
     * Constructor
     * @param int userId 
     * @param String userName
     */
    Admin(int userId, String userName) {
        id = userId;
        name = userName;
    }

    @Override
    public boolean canAddData() {
        return true;
    }

    @Override
    public boolean canReport() {
        return true;
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
}
