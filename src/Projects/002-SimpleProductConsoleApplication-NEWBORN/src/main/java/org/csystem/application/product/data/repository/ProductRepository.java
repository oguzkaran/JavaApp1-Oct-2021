package org.csystem.application.product.data.repository;

import org.csystem.application.product.data.entity.Product;

import java.math.BigDecimal;

public class ProductRepository { // Bu tarz sınıflar için ileride çok değişiklik yapılacaktır
    private final Product [] m_products;
    private int m_index;

    public ProductRepository(int n)
    {
        m_products = new Product[n];
    }

    public boolean save(Product product)
    {
        if (m_index == m_products.length)
            return false;

        product.setId(m_index + 1);
        m_products[m_index++] = product;

        return true;
    }

    public boolean isAvailable()
    {
        return m_products.length != m_index;
    }

    public Product findExpensive()
    {
        if (m_index == 0)
            return null;

        var result = m_products[0];

        for (int i = 1; i < m_index; ++i)
            if (result.getUnitPrice().compareTo(m_products[i].getUnitPrice()) < 0)
                result = m_products[i];

        return result;
    }

    public Product findCheap()
    {
        if (m_index == 0)
            return null;

        var result = m_products[0];

        for (int i = 1; i < m_index; ++i)
            if (m_products[i].getUnitPrice().compareTo(result.getUnitPrice()) < 0)
                result = m_products[i];

        return result;
    }

    public BigDecimal findTotal()
    {
        var total = BigDecimal.ZERO;

        for (var i = 0; i < m_index; ++i) {
            var p = m_products[i];
            total = total.add(p.getUnitPrice().subtract(p.getCost()).multiply(BigDecimal.valueOf(p.getStock())));
        }

        return total;
    }
}
