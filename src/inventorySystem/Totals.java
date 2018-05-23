
package inventorySystem;

/**
 *
 * @author angel
 */
public class Totals {
    private Product product;
    private Integer quantity;
    private Double cost;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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

    public Totals(Product product, Integer quantity, Double cost) {
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
    }
    
}
