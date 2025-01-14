package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    private final BigDecimal exciseTax = new BigDecimal("5.56");



    protected Product(String name, BigDecimal price, BigDecimal tax) {
        if (name == null || name.equals("") || price == null || tax == null
                || tax.compareTo(new BigDecimal(0)) < 0
                || price.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return price.multiply(taxPercent).add(price);
    }

    public BigDecimal getPriceWithTaxWithExciseTax() {
        return price.multiply(taxPercent).add(price).add(exciseTax);
    }

    /*
    public BigDecimal getPriceWithTaxWithExciseTaxOnCarpentersDay() {
        int cYear = 2022;
        int cMonth = 3;
        int cDayOfMonth = 19;
        ChronoLocalDate carpentersDay = LocalDate.of(cYear, cMonth, cDayOfMonth);
        carpentersDay = LocalDate.now(); //emulation of carpentersDay
        if (LocalDate.now().equals(carpentersDay) && product.isFuel) {
            return price.multiply(taxPercent).add(price);
        }
        return price.multiply(taxPercent).add(price).add(exciseTax);
    }
    */
}
