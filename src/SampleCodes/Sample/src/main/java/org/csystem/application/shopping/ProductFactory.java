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
        //TODO:
    }

    public void decrementProductByRatio(double ratio)
    {
        //TODO:
    }

    public Product [] getProducts()
    {
        return m_products;
    }
}
