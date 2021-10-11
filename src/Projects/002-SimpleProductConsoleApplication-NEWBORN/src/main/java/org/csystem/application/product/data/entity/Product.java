package org.csystem.application.product.data.entity;

import java.math.BigDecimal;

public class Product {
    private int m_id;
    private String m_code;
    private String m_name;
    private double m_stock;
    private BigDecimal m_cost;
    private BigDecimal m_unitPrice;

    //Bu ctor şimdilik gerekli olmasa da ileride gerekli olacak
    public Product()
    {
        //...
    }

    //Bu ctor'un parametre sayısı çok fazla. Acaba doğru bir yaklaşım mı? Genel olarak hayır. İleride düzelteceğiz
    public Product(int id, String code, String name, double stock, BigDecimal cost, BigDecimal unitPrice)
    {
        m_id = id;
        m_code = code;
        m_name = name;
        m_stock = stock;
        m_cost = cost;
        m_unitPrice = unitPrice;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getCode()
    {
        return m_code;
    }

    public void setCode(String code)
    {
        m_code = code;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
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
}
