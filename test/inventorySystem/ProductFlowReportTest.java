/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angel
 */
public class ProductFlowReportTest {
    /**
     * 25 May 2018
     */
    public static final long TESTDATE = 1527228339866L;
    public ProductFlowReportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDate method, of class ProductFlowReport.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        Date expResult = new Date(ProductFlowReportTest.TESTDATE);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class ProductFlowReport.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = new Date(ProductFlowReportTest.TESTDATE+100);
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        instance.setDate(date);
        Date result = instance.getDate();
        assertEquals(date, result);
    }

    /**
     * Test of getUser method, of class ProductFlowReport.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        String expResult = "User";
        String result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUser method, of class ProductFlowReport.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "OtherUser";
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        instance.setUser(user);
        String result = instance.getUser();
        assertEquals(user, result);
    }

    /**
     * Test of getProduct method, of class ProductFlowReport.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        String expResult = "Product";
        String result = instance.getProduct();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProduct method, of class ProductFlowReport.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        String product = "OtheProduct";
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        instance.setProduct(product);
        String result = instance.getProduct();
        assertEquals(product, result);
    }

    /**
     * Test of getQuantity method, of class ProductFlowReport.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        Integer expResult = 10;
        Integer result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantity method, of class ProductFlowReport.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Integer quantity = 20;
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        instance.setQuantity(quantity);
        Integer result = instance.getQuantity();
        assertEquals(quantity, result);
    }

    /**
     * Test of getCost method, of class ProductFlowReport.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        Double expResult = 0.5;
        Double result = instance.getCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCost method, of class ProductFlowReport.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        Double cost = 42.42;
       ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        instance.setCost(cost);
        Double result = instance.getCost();
        assertEquals(cost, result);
    }

    /**
     * Test of getFormattedDate method, of class ProductFlowReport.
     */
    @Test
    public void testGetFormattedDate() {
        System.out.println("getFormattedDate");
        ProductFlowReport instance = new ProductFlowReport(new Date(ProductFlowReportTest.TESTDATE), "Product", 10, 0.5, "User");
        String expResult = "25/05/18";
        String result = instance.getFormattedDate();
        assertEquals(expResult, result);
    }
}
