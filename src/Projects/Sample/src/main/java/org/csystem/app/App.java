/*----------------------------------------------------------------------------------------------------------------------
    Colloctors sınıfının joining metodu ile yazı birleştirmesi ayraç, prefix ve suffix kullanılarak yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.data.factory.MyProductFactory;
import org.csystem.data.product.ProductInfo;
import org.csystem.util.Console;

import java.util.stream.Collectors;

class App {
    public static void main(String[] args)
    {
        try {
            var factory = MyProductFactory.loadFromTextFile("products-temp.csv");
            var products = factory.PRODUCTS;

            var str = products.stream().map(ProductInfo::getName)
                    .map(s -> "[[" + s + "]]")
                    .collect(Collectors.joining(" :: ", "{", "}"));

            Console.writeLine(str);

        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}