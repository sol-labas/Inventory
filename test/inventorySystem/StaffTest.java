
package inventorySystem;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class StaffTest {
    
    public StaffTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of canAddData method, of class Staff.
     */
    @Test
    public void testCanAddData() {
        System.out.println("canAddData");
        Staff instance = new Staff(1, "Vasya");
        boolean expResult = false;
        boolean result = instance.canAddData();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of canReport method, of class Staff.
     */
    @Test
    public void testCanReport() {
        System.out.println("canReport");
        Staff instance = new Staff(1, "Kolya");
        boolean expResult = true;
        boolean result = instance.canReport();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of getName method, of class Staff.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Staff instance = new Staff(2, "Katya");
        String expResult = "Katya";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Staff.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Polya";
        Staff instance = new Staff(3, "Maya");
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    /**
     * Test of getId method, of class Staff.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Staff instance = new Staff(3, "Maya");
        int expResult = 3;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Staff.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 3;
         Staff instance = new Staff(3, "Maya");
        instance.setId(id);
        int result = instance.getId();
        assertEquals(id, result);
    }
    
}
