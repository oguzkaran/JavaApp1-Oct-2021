package org.csystem.application.shopping;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductFactory {
    private final Product [] m_products;

    public ProductFactory()
    {
        m_products  = new Product[] {
                new Product("Sıvı Yağ", LocalDate.of(2021, 12, 15), 100.3, BigDecimal.valueOf(50.45), BigDecimal.valueOf(99.99)),
                new Product("Bal", LocalDate.of(2024, 12, 15), 200.45, BigDecimal.valueOf(200), BigDecimal.valueOf(299.99)),
                new Product("Peynir", LocalDate.of(2021, 12, 3), 30, BigDecimal.valueOf(50), BigDecimal.valueOf(79.99)),
        };
    }

    public void incrementProductByRatio(double ratio)
    {
        //İleride döngü kullanmayacağız
        for (var p : m_products) {
            var unitPrice = p.getUnitPrice();

            unitPrice = unitPrice.add(unitPrice.multiply(BigDecimal.valueOf(ratio / 100)));
            p.setUnitPrice(unitPrice);
        }
    }

    public void decrementProductByRatio(double ratio)
    {
        //İleride döngü kullanmayacağız
        for (var p : m_products) {
            var unitPrice = p.getUnitPrice();

            unitPrice = unitPrice.subtract(unitPrice.multiply(BigDecimal.valueOf(ratio / 100)));
            p.setUnitPrice(unitPrice);
        }
    }

    public Product [] getProducts()
    {
        return m_products;
    }
}
