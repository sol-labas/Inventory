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
public class TotalsTest {
    
    public TotalsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getProduct method, of class Totals.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        Product product = new Product(7, "Computer");
        Totals instance = new Totals(product, 18, 36.0);
        Product expResult = product;
        Product result = instance.getProduct();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProduct method, of class Totals.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        Product product = new Product(15, "Mouse");
        Totals instance = new Totals(new Product(7, "Computer"), 18, 36.0);
        instance.setProduct(product);
        Product result = instance.getProduct();
        assertEquals(product, result);
    }

    /**
     * Test of getQuantity method, of class Totals.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Totals instance = new Totals(new Product(7, "Computer"), 18, 36.0);
        Integer expResult = 18;
        Integer result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantity method, of class Totals.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Integer quantity = 42;
        Totals instance = new Totals(new Product(7, "Computer"), 18, 36.0);
        instance.setQuantity(quantity);
        Integer result = instance.getQuantity();
        assertEquals(quantity, result);
    }

    /**
     * Test of getCost method, of class Totals.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Totals instance = new Totals(new Product(7, "Computer"), 18, 36.0);
        Double expResult = 36.0;
        Double result = instance.getCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCost method, of class Totals.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        Double cost = 735.32;
        Totals instance = new Totals(new Product(7, "Computer"), 18, 36.0);
        instance.setCost(cost);
        Double result = instance.getCost();
        assertEquals(cost, result);
    }
    
}
