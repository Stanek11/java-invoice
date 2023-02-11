package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
<<<<<<< HEAD
        return this.price.multiply(this.taxPercent).add(this.price);
=======
        return this.getPrice().multiply(this.taxPercent).add(this.price);
>>>>>>> 3025e998b7940debad10748c0e2580041bf4aa9d
    }
}
