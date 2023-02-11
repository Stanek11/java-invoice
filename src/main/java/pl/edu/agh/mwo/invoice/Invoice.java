package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products;

    public Invoice() {

        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        if (product == null) {

            throw new IllegalArgumentException("Product can not be null.");
        }
        this.products.add(product);
    }

    public void addProduct(Product product, Integer quantity) {
        if  (quantity <= 0) {

            throw new IllegalArgumentException("Quantity can not be negative");
        }
    }

    public BigDecimal getSubtotal() {
        return null;
    }

    public BigDecimal getTax() {
        return null;
    }

    public BigDecimal getTotal() {
        return null;
    }
}
