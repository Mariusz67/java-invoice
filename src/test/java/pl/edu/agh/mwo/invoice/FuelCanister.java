package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.OtherProduct;

import java.math.BigDecimal;

public class FuelCanister extends OtherProduct {

    public FuelCanister(String name, BigDecimal price) {
        super(name, price);
    }
}
