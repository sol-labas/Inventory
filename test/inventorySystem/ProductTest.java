/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Product instance = new Product(5, "Chair");
        Integer expResult = 5;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product(5, "Chair");
        String expResult = "Chair";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Product.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 8;
        Product instance = new Product(5, "Chair");
        instance.setId(id);
        Integer result = instance.getId();
        assertEquals(id, result);
    }

    /**
     * Test of setName method, of class Product.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Hook";
        Product instance = new Product(5, "Chair");
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }
}
