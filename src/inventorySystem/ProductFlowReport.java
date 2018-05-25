/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorySystem;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author angel
 */
public class ProductFlowReport {
    private String product;
    private Integer quantity;
    private Double cost;
    private String user;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    /**
     * Constructor
     * @param Date date 
     * @param String product 
     * @param Integer quantity 
     * @param Double cost
     * @paramString user 
     */
    public ProductFlowReport(Date date, String product, Integer quantity, Double cost, String user) {
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.user = user;
    }
    /**
     * Format date to String
     * @param  
     */
    public String getFormattedDate() {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormatter.format(this.date);
    }
    
}
