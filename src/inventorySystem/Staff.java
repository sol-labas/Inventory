/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

/**
 *
 * @author angel
 */
public class Staff implements User {
    private String name;
    private int id;

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
