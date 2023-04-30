
package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private final Map<Product, Integer> products = new HashMap<Product, Integer>();
    public final int invoiceNumber;
    public static int nextNumber = 1;

    public Invoice() {

        this.invoiceNumber = ++nextNumber;
    }


    public void printInvoice() {
        System.out.println("Number of Invoice: " + getInvoiceNumber());

        for (Product product : products.keySet()) {
            System.out.println(product.getName() + " " + products.get(product) + " " + product.getPrice() + "zł");
        }
        System.out.println("Number of items: " + getNumberOfItems());
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getNumberOfItems() {
        return products.size();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        products.put(product, quantity);


    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }
}
