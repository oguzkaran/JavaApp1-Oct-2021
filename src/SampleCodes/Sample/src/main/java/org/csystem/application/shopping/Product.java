package org.csystem.application.shopping;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private long m_id;
    private String m_name;
    private LocalDate m_expiryDate;
    private double m_stock;
    private BigDecimal m_cost;
    private BigDecimal m_unitPrice;

    public Product()
    {
    }

    public Product(String name, LocalDate expiryDate, double stock, BigDecimal cost, BigDecimal unitPrice)
    {
        this(0, name, expiryDate, stock, cost, unitPrice);
    }

    public Product(long id, String name, LocalDate expiryDate, double stock, BigDecimal cost, BigDecimal unitPrice)
    {
        //...
        m_id = id;
        m_name = name;
        m_expiryDate = expiryDate;
        m_stock = stock;
        m_cost = cost;
        m_unitPrice = unitPrice;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public LocalDate getExpiryDate()
    {
        return m_expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate)
    {
        m_expiryDate = expiryDate;
    }

    public double getStock()
    {
        return m_stock;
    }

    public void setStock(double stock)
    {
        m_stock = stock;
    }

    public BigDecimal getCost()
    {
        return m_cost;
    }

    public void setCost(BigDecimal cost)
    {
        m_cost = cost;
    }

    public BigDecimal getUnitPrice()
    {
        return m_unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        m_unitPrice = unitPrice;
    }

    public BigDecimal getTotal()
    {
        return m_unitPrice.subtract(m_cost).multiply(BigDecimal.valueOf(m_stock));
    }

    @Override
    public String toString()
    {
        return String.format("[%s] %s, %s = %s", m_name, m_cost, m_unitPrice, this.getTotal());
    }
}
