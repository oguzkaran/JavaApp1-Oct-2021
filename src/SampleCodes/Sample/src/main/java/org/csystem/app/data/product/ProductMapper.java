package org.csystem.app.data.product;

public class ProductMapper {
    //...
    public ProductNameStockDTO toProductStockDTO(ProductInfo productInfo)
    {
        return new ProductNameStockDTO(productInfo.getName(), productInfo.getStock());
    }
}
